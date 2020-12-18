package introductionAlgorithm.sort;

/**
 * @author liumt
 * @date Created in 2020/12/3 17:33
 * 建堆
 */
public class Heapsort6_3 {
    /**
     * 从非叶子节点,开始调用维护最大堆的性质
     * 建最大堆
     * @param array 二叉堆
     */
    public static void buildMaxHeap(int[] array) {
        int unLeaf = (array.length - 2) / 2;
        for (int i = unLeaf; i >=0; i--) {
            Heapsort6_2.maxHeapify2(array, i, array.length - 1);
        }
    }
}
