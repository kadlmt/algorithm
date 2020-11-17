package sort;

/**
 * @author liumt
 * @date Created in 2020/11/17 12:39
 * 插入排序
 */
public class InsertionSort {
    /**
     * 升序
     * @param array 待排序的数组
     */
    public static void insertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && key < array[i]) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    /**
     * 降序
     * @param array 待排序的数组
     */
    public static void insertionSort2(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && key > array[i]) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {31, 41, 59, 26, 41, 58};
        insertionSort2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
