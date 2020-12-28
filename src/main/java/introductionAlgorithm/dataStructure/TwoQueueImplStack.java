package introductionAlgorithm.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liumt
 * @date Created in 2020/12/28 12:36
 * 两个队列实现栈
 */
public class TwoQueueImplStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public Boolean isEmpty() {
        if (queue1.isEmpty() && queue2.isEmpty()) return true;
        return false;
    }

    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.add(x);
        } else {
            queue2.add(x);
        }
    }

    public int pop() {
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        } else if (!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        } else {
            throw new StackOverflowError("下溢");
        }
    }

    public static void main(String[] args) {
        TwoQueueImplStack stack = new TwoQueueImplStack();
        stack.push(1);
        stack.push(3453);
        stack.push(5646);
        stack.push(865);
        stack.push(22);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(78777);
        stack.push(88888);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
