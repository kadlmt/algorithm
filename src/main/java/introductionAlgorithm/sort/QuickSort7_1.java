package introductionAlgorithm.sort;

/**
 * @author liumt
 * @date Created in 2020/12/17 12:31
 * 快速排序,递增
 */
public class QuickSort7_1 {
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

    public static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
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
//        int[] array = {5, 2, 4, 7, 1, 3, 2, 6};
        int[] array = {5, 5, 5, 5, 5, 5, 5, 5};
        quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
