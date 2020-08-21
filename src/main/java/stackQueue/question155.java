package stackQueue;

import java.util.Stack;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/21 23:12
 * @description：最小元素栈
 * @modified By：
 * @version: 1.1
 */
public class question155 {

    /*
     * @Author liumt
     * @Description 一个栈正常存放,另一个栈,存放最小值
     * @Date 23:13 2020/8/21
     * @Param
     * @return
     **/
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack();
            minStack = new Stack();
        }

        public void push(int x) {
            stack.push(x);
            if(minStack.isEmpty() || x <= minStack.peek()){
                minStack.push(x);
            }
        }

        public void pop() {
            if(stack.pop().equals(minStack.peek())){
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
