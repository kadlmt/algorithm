package introductionAlgorithm.sort;

/**
 * @author liumt
 * @date Created in 2020/12/4 16:24
 * 堆排序
 */
public class Heapsort6_4 {
    public static void heapsort(int[] array) {
        int length = array.length - 1;
        Heapsort6_3.buildMaxHeap(array);
        for (int i = length; i >= 0; i--) {
            int tempValue= array[i];
            array[i] = array[0];
            array[0] = tempValue;
            Heapsort6_2.maxHeapify2(array, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 13, 2, 25, 7, 17, 20, 8, 4};
        heapsort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
