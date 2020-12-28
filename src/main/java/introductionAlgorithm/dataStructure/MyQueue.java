package introductionAlgorithm.dataStructure;

/**
 * @author liumt
 * @date Created in 2020/12/24 12:11
 * 队列
 * todo 动态扩容
 */
public class MyQueue {
    private int[] value;
    // 等待出队的位置
    private int head;
    // 等待入队的位置
    private int tail;

    public MyQueue(int capacity) {
        this.value = new int[capacity];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 入队
     */
    public void enQueue(int x) {
        if (isFull()) throw new StackOverflowError();
        value[tail++] = x;
        if (tail == value.length)
            tail = 0;
    }

    /**
     * 出队
     */
    public int deQueue() {
        if (isEmpty()) throw new StackOverflowError();
        int x = value[head];
        value[head++] = 0;
        if (head == value.length)
            head = 0;
        return x;
    }

    /**
     * 判断队列是否为空
     */
    public Boolean isEmpty() {
        if (head == tail)
            return true;
        return false;
    }

    /**
     * 判断队列是否满
     */
    public Boolean isFull() {
        if (head == tail + 1 || (head == 0 && tail == value.length - 1))
            return true;
        return false;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);
        for (int i = 0; i < 3; i++) {
            queue.enQueue(1);
            queue.enQueue(56);
            queue.enQueue(23);
            queue.enQueue(45);
            queue.enQueue(86);
            queue.enQueue(123);
            System.out.println(queue.deQueue());
            System.out.println(queue.deQueue());
            System.out.println(queue.deQueue());
            System.out.println(queue.deQueue());
            System.out.println(queue.deQueue());
            System.out.println(queue.deQueue());
        }
    }
}
