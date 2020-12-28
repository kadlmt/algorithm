package introductionAlgorithm.dataStructure;

/**
 * @author liumt
 * @date Created in 2020/12/25 12:08
 * 双端队列
 */
public class MyDeque {
    private int[] value;
    private int head;
    private int tail;

    public MyDeque(int capacity) {
        this.value = new int[capacity];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 是否为空
     */
    public Boolean isEmpty() {
        if (head == tail) return true;
        return false;
    }

    /**
     * 是否满
     */
    public Boolean isFull() {
        if (tail + 1 == head || (head == 0 && tail == value.length - 1)) return true;
        return false;
    }

    /**
     * 队头入队
     */
    public void headEnqueue(int x) {
        if (isFull()) throw new StackOverflowError("上溢");
        head--;
        if (head < 0) head = value.length - 1;
        value[head] = x;
    }

    /**
     * 队头出队
     */
    public int headDequeue() {
        if (isEmpty()) throw new StackOverflowError("下溢");
        int x = value[head];
        head++;
        if (head == value.length) head = 0;
        return x;
    }

    /**
     * 队尾入队
     */
    public void tailEnqueue(int x) {
        if (isFull()) throw new StackOverflowError("上溢");
        value[tail++] = x;
        if (tail == value.length) tail = 0;
    }

    /**
     * 队尾出队
     */
    public int tailDequeue() {
        if (isEmpty()) throw new StackOverflowError("下溢");
        tail--;
        if (tail < 0) tail = value.length - 1;
        return value[tail];
    }

    public static void main(String[] args) {
        MyDeque queue = new MyDeque(10);
        for (int i = 0; i < 3; i++) {
            queue.headEnqueue(1);
            queue.headEnqueue(56);
            queue.headEnqueue(23);
            queue.tailEnqueue(45);
            queue.tailEnqueue(86);
            queue.tailEnqueue(123);
            System.out.println(queue.headDequeue());
            System.out.println(queue.headDequeue());
            System.out.println(queue.tailDequeue());
            System.out.println(queue.tailDequeue());
            System.out.println(queue.headDequeue());
            System.out.println(queue.tailDequeue());
        }
    }
}
