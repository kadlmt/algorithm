package stackQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/20 13:00
 * @description：队列模拟栈
 * @modified By：
 * @version: 1.1
 */
public class question225 {
    Deque<Integer> deque;
    /** Initialize your data structure here. */
    public question225() {
        deque = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int size = deque.size();
        deque.offer(x);
        for(int i = 0; i < size; i++){
            deque.offer(deque.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque.poll();
    }

    /** Get the top element. */
    public int top() {
        return deque.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque == null || deque.size() <= 0;
    }
}
