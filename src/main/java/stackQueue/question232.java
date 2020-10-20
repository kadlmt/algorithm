package stackQueue;

import java.util.Stack;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/21 0:06
 * @description：用栈实现队列
 * @modified By：
 * @version: 1.1
 */
public class question232 {
    /*
     * @Author liumt
     * @Description s1进栈用,s2出栈用
     * 每次peek,pop时,如果s2为空,s1的数据全pop到s2
     * @Date 0:06 2020/8/21
     * @Param
     * @return
     **/
    public class MyQueue{
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(!stack2.isEmpty()){
                return stack2.pop();
            }else{
                unshift();
                return stack2.pop();
            }
        }

        public void unshift(){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        /** Get the front element. */
        public int peek() {
            if(!stack2.isEmpty()){
                return stack2.peek();
            }else{
                unshift();
                return stack2.peek();
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
