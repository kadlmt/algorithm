package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/8 11:44
 * @description：字符串转换为整数
 * @modified By：
 * @version: 1.1
 */
public class question8 {
    /**
     * @Author liumt
     * @Description 有限状态机
     * @Date 11:47 2020/10/8
     * @Param [s]
     * @return int
     **/
    public int myAtoi(String s) {
        Automaton autoMaton = new Automaton();
        for(int i = 0; i < s.length(); i++){
            autoMaton.set(s.charAt(i));
        }
        return (int) (autoMaton.getSign() * autoMaton.getAns());
    }

    class Automaton {
        private int sign = 1;
        private long ans = 0;
        private String state;
        private Map<String, String[]> stateTable = new HashMap<>();
        public Automaton(){
            //'', +/-, number, other
            stateTable.put("start", new String[]{"start", "signed", "in_number", "end"});
            stateTable.put("signed", new String[]{"end", "end", "in_number", "end"});
            stateTable.put("in_number", new String[]{"end", "end", "in_number", "end"});
            stateTable.put("end", new String[]{"end", "end", "end", "end"});
            this.state = "start";
        }

        public void set(char c){
            state = stateTable.get(state)[getCol(c)];
            if("in_number".equals(state)){
                ans = ans * 10 + (c - '0');
                ans = sign == 1?Math.min(ans, (long) Integer.MAX_VALUE):
                        Math.min(ans, -(long) Integer.MIN_VALUE);
            }
            if("signed".equals(state)){
                sign = c == '+'?1: -1;
            }
        }

        private int getCol(char c){
            if(c == ' ') return 0;
            if(c == '+' || c == '-') return 1;
            if(Character.isDigit(c)) return 2;
            return 3;
        }

        public int getSign(){
            return this.sign;
        }

        public long getAns(){
            return this.ans;
        }
    }
}
