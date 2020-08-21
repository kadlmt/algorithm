package stackQueue;

import java.util.Stack;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/21 23:29
 * @description：有效的括号
 * @modified By：
 * @version: 1.1
 */
public class question20 {
    /*
     * @Author liumt
     * @Description 检测到左括号,就把右括号放入栈
     * 检测到非左括号,就和栈顶对比
     * 如果栈为空,或者栈顶不等于c返回空,不合法
     * 最终如果栈不为空,则括号多了,不合法
     * @Date 23:29 2020/8/21
     * @Param [s]
     * @return boolean
     **/
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(') stack.push(')');
            else if(c == '{') stack.push('}');
            else if(c == '[') stack.push(']');
            else if(stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
