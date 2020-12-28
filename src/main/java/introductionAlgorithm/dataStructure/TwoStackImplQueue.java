package introductionAlgorithm.dataStructure;

import java.util.Stack;

/**
 * @author liumt
 * @date Created in 2020/12/25 12:36
 * 使用两个栈实现队列
 */
public class TwoStackImplQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队
     */
    public void enQueue(int x) {
        stack1.push(x);
    }

    /**
     * 出队
     */
    public int deQueue() {
        if (stack2.isEmpty()) {
            unshift();
            return stack2.pop();
        }
        return stack2.pop();
    }

    /**
     * stack1 -> stack2
     */
    public void unshift() {
       while (!stack1.isEmpty()) {
           stack2.push(stack1.pop());
       }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);
        for (int i = 0; i < 3; i++) {
            queue.enQueue(1);
            queue.enQueue(56);
            queue.enQueue(23);
            System.out.println(queue.deQueue());
            queue.enQueue(45);
            queue.enQueue(86);
            queue.enQueue(123);
            System.out.println(queue.deQueue());
            System.out.println(queue.deQueue());
            System.out.println(queue.deQueue());
            System.out.println(queue.deQueue());
            System.out.println(queue.deQueue());
        }
    }
}
