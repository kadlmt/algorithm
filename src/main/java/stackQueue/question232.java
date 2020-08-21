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
        private Stack<Integer> s1;
        private Stack<Integer> s2;
        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        public void shift(){
            if(s2.empty()){
                while(!s1.empty()){
                    s2.push(s1.pop());
                }
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            shift();
            if(!s2.empty()){
                return s2.pop();
            }
            throw new RuntimeException("error");
        }

        /** Get the front element. */
        public int peek() {
            shift();
            if(!s2.empty()){
                return s2.peek();
            }
            throw new RuntimeException("error");
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.empty() && s2.empty();
        }
    }
}
