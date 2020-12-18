package introductionAlgorithm.sort;

/**
 * @author liumt
 * @date Created in 2020/12/3 15:34
 * 维护堆的性质
 */
public class Heapsort6_2 {
    /**
     * 下沉操作,维护最大堆的性质
     * 由于存在递归,效率不行
     * @param array 二叉堆
     * @param cur 需要下沉的数组索引
     * @param length 数组有效长度
     */
    public static void maxHeapify(int[] array, int cur, int length) {
        int leftIndex = cur * 2 + 1;
        int rightIndex = cur * 2 + 2;
        int largeIndex = cur;
        if (leftIndex <= length && array[largeIndex] < array[leftIndex]) {
            largeIndex = leftIndex;
        }
        if (rightIndex <= length && array[largeIndex] < array[rightIndex]) {
            largeIndex = rightIndex;
        }
        // 交换数据,然后递归继续下沉
        if (largeIndex != cur) {
            int curValue = array[cur];
            array[cur] = array[largeIndex];
            array[largeIndex] = curValue;
            maxHeapify(array, largeIndex, length);
        }
    }

    /**
     * 下沉操作,维护最小堆的性质
     * 由于存在递归,效率不行
     * @param array 二叉堆
     * @param cur 需要下沉的索引
     * @param length 数组有效长度
     */
    public static void minHeapify(int[] array, int cur, int length) {
        int leftIndex = cur * 2 + 1;
        int rightIndex = cur * 2 + 2;
        int littleIndex = cur;
        if (leftIndex <= length && array[littleIndex] > array[leftIndex]) {
            littleIndex = leftIndex;
        }
        if (rightIndex <= length && array[littleIndex] > array[rightIndex]) {
            littleIndex = rightIndex;
        }
        // 交换数据,然后递归继续下沉
        if (littleIndex != cur) {
            int curValue = array[cur];
            array[cur] = array[littleIndex];
            array[littleIndex] = curValue;
            maxHeapify(array, littleIndex, length);
        }
    }

    /**
     * 下沉操作,维护最大堆的性质
     * 使用迭代的方式替换递归
     * @param array 二叉堆
     * @param cur 需要下沉的数组索引
     */
    public static void maxHeapify2(int[] array, int cur, int length) {
        while (true) {
            int leftIndex = cur * 2 + 1;
            int rightIndex = cur * 2 + 2;
            int largeIndex = cur;
            if (leftIndex <= length && array[largeIndex] < array[leftIndex]) {
                largeIndex = leftIndex;
            }
            if (rightIndex <= length && array[largeIndex] < array[rightIndex]) {
                largeIndex = rightIndex;
            }
            if (largeIndex == cur) {
                return;
            }
            int curValue = array[cur];
            array[cur] = array[largeIndex];
            array[largeIndex] = curValue;
            cur = largeIndex;
        }
    }

    /**
     * 下沉操作,维护最小堆的性质
     * 使用迭代的方式替换递归
     * @param array 二叉堆
     * @param cur 需要下沉的索引
     */
    public static void minHeapify2(int[] array, int cur, int length) {
        while (true) {
            int leftIndex = cur * 2 + 1;
            int rightIndex = cur * 2 + 2;
            int littleIndex = cur;
            if (leftIndex <= length && array[littleIndex] > array[leftIndex]) {
                littleIndex = leftIndex;
            }
            if (rightIndex <= length && array[littleIndex] > array[rightIndex]) {
                littleIndex = rightIndex;
            }
            if (littleIndex == cur) {
                return;
            }
            int curValue = array[cur];
            array[cur] = array[littleIndex];
            array[littleIndex] = curValue;
            cur = littleIndex;
        }
    }
}
