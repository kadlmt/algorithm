package introductionAlgorithm.dataStructure;

/**
 * @author liumt
 * @date Created in 2020/12/22 12:34
 * 栈
 */
public class MyStack {
    private int[] value;

    private int top = 0;

    public MyStack(Integer capacity) {
        this.value = new int[capacity];
    }

    public Boolean isEmpty() {
        if (top == 0) return true;
        return false;
    }

    public void push(int item) {
        value[top++] = item;
    }

    public int pop() {
        if (isEmpty()) throw new StackOverflowError();
        return value[--top];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        System.out.println(stack.isEmpty());
        stack.push(1);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
