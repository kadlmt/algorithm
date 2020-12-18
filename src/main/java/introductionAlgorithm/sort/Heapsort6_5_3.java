package introductionAlgorithm.sort;

/**
 * @author liumt
 * @date Created in 2020/12/10 12:40
 * 最小优先级队列
 */
public class Heapsort6_5_3 {
    private int[] array;
    private int size;

    public Heapsort6_5_3(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    public void minHeapInsert(int key) throws Exception {
        array[size++] = Integer.MAX_VALUE;
        heapDecreaseKey(size - 1, key);
    }

    public int heapMinimum() throws Exception {
        if (size == 0) throw new Exception("queue is empty");
        return array[0];
    }

    public int heapExtractMin() throws Exception {
        if (size == 0) throw new Exception("queue is empty");
        if (size == 1) {
            int min = array[0];
            array[0] = 0;
            return min;
        }
        int min = array[0];
        array[0] = array[--size];
        array[size] = 0;
        Heapsort6_2.minHeapify2(array, 0, size - 1);
        return min;
    }

    public void heapDecreaseKey(int x, int key) throws Exception {
        if (array[x] < key) throw new Exception("new key is larger than current key");
        array[x] = key;
        int parentIndex = (x - 1) / 2;
        while (parentIndex >=0 && array[parentIndex] > array[x]) {
            int temp = array[x];
            array[x] = array[parentIndex];
            array[parentIndex] = temp;
            x = parentIndex;
            parentIndex = (x - 1) / 2;
        }
    }
}
