package introductionAlgorithm.sort;

/**
 * @author liumt
 * @date Created in 2020/12/4 16:39
 * 最大优先级队列(不支持扩容)
 */
public class Heapsort6_5 {
    /**
     * 优先级队列
     */
    private int[] array;
    /**
     * 有效大小
     */
    private int size;

    public Heapsort6_5(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    /**
     * 插入操作
     * @param key 插入值
     */
    public void maxHeapInsert(int key) throws Exception {
        array[size++] = Integer.MIN_VALUE;
        heapIncreaseKey(size - 1, key);
    }

    /**
     * 返回最大值
     * @return 最大值
     */
    public int heapMaximum() throws Exception {
        if (size == 0) throw new Exception("queue is empty");
        return array[0];
    }

    /**
     * 去掉并返回最大值
     * @return 最大值
     */
    public int heapExtractMax() throws Exception {
        if (size == 0) throw new Exception("queue is empty");
        if (size == 1) {
            int max = array[0];
            array[0] = 0;
            return max;
        }
        int max = array[0];
        array[0] = array[--size];
        array[size] = 0;
        Heapsort6_2.maxHeapify2(array, 0, size - 1);
        return max;
    }

    /**
     * 增加x的值到k
     * @param i index
     * @param key newKey
     */
    public void heapIncreaseKey(int i, int key) throws Exception {
        if (array[i] > key) throw new Exception("new key is smaller than current key");
        array[i] = key;
        int parentIndex = (i - 1) / 2;
        while (i >= 0 && array[parentIndex] < array[i]) {
            int temp = array[i];
            array[i] = array[parentIndex];
            array[parentIndex] = temp;
            i = parentIndex;
            parentIndex = (i - 1) / 2;
        }
    }
}
