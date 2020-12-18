package introductionAlgorithm.sort;

import java.util.Random;

/**
 * @author liumt
 * @date Created in 2020/12/18 12:31
 * 随机化快排,主元的选取随机
 */
public class QuickSort7_3 {
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }

    }

    public static int randomPartition(int[] array, int p, int r) {
        Random random = new Random();
        int i = random.nextInt() * (r - p + 1) + p;
        int temp = array[i];
        array[i] = array[r];
        array[r] = temp;
        return partition(array, p, r);
    }

    public static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            // 和递增唯一的不同,把大的数字放左边
            if (array[j] < x) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[r] = array[i + 1];
        array[i + 1] = x;
        return i + 1;
    }

    public static void main(String[] args) {
        // 排序测试用例
        int[] array = {5, 2, 4, 7, 1, 3, 2, 6};
        quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
