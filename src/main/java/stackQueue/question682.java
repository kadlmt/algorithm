package stackQueue;

import java.util.Stack;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/16 12:59
 * @description：你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 *
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 * @modified By：
 * @version: 1.1
 */
public class question682 {
    /**
     * @Author liumt
     * @Description 使用栈记录每一回合的得分
     * @Date 12:59 2020/9/16
     * @Param [ops]
     * @return int
     **/
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String s: ops){
            if(s.equals("+")){
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if(s.equals("D")){
                stack.push(stack.peek() * 2);
            } else if(s.equals("C")){
                stack.pop();
            } else{
                stack.push(Integer.valueOf(s));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
