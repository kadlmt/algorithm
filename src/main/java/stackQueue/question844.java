package stackQueue;

import java.util.Stack;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/16 12:42
 * @description：比较含退格的字符串,#表示退格.
 * @modified By：
 * @version: 1.1
 */
public class question844 {
    /**
     * @Author liumt
     * @Description 使用栈,不是#就放入栈,是#就倒出栈顶元素.
     * @Date 12:42 2020/9/16
     * @Param [S, T]
     * @return boolean
     **/
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String s){
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for(char c: s.toCharArray()){
            if(c != '#'){
                stack.push(c);
            } else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
