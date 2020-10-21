package stackQueue;

import java.util.Stack;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/21 12:56
 * @description：检查替换后的词是否有效.s是否由"abc"插入abc得到
 * @modified By：
 * @version: 1.1
 */
public class question1003 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty() || c != 'c'){
                stack.push(c);
            } else{
                if(stack.isEmpty() || 'b' != stack.pop()) return false;
                if(stack.isEmpty() || 'a' != stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }
}
