package sort;

/**
 * @author liumt
 * @date Created in 2020/11/17 17:18
 * 归并排序
 */
public class MergeSort {
    /**
     * 逆序对数量
     */
    private static int reversePairs = 0;

    public static void mergeSort(int[] array, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            reversePair(array, p, q, r);
        }
    }

    /**
     * 使用哨兵
     */
    public static void merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        // 把排序好的两部分,进行合并排序
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = array[p + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = array[q + i + 1];
        }
        // 设置哨兵
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        // 开始合并排序
        int i = 0;
        int j = 0;
        for (int k = p; k < r + 1; k++) {
            if (L[i] < R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
        }
    }

    /**
     * 不使用哨兵
     */
    public static void merge2(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        // 把排序好的两部分,进行合并排序
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = array[p + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = array[q + i + 1];
        }
        // 开始合并排序
        int i = 0;
        int j = 0;
        for (int k = p; k < r + 1; k++) {
            if (L[i] < R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            if (i == n1) {
                while (j < n2) {
                    array[++k] = R[j++];
                }
                break;
            }
            if (j == n2) {
                while (i < n1) {
                    array[++k] = L[i++];
                }
            }
        }
    }

    /**
     * 求解逆序对数量
     */
    public static void reversePair(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 =  r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = array[p + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = array[q + i + 1];
        }
        int i = 0;
        int j = 0;
        for (int k = p; k < r + 1; k++) {
            if (L[i] > R[j]) {
                array[k] = R[j++];
                // 计算逆序对的关键所在,如果L[i] > R[j],则i后面的所有数字都大于R[j]
                reversePairs += n1 - i;
            } else {
                array[k] = L[i++];
            }
            if (i == n1) {
                while (j < n2) {
                    array[++k] = R[j++];
                }
                break;
            }
            if (j == n2) {
                while (i < n1) {
                    array[++k] = L[i++];
                }
            }
        }
    }

    public static void main(String[] args) {
        // 排序测试用例
//        int[] array = {5, 2, 4, 7, 1, 3, 2, 6};
//        mergeSort(array, 0, array.length - 1);
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }

        // 求解逆序对测试用例
        int[] array = {2, 3, 8, 6, 1};
//        int[] array = {5, 4, 3, 2, 1};
        mergeSort(array, 0, array.length - 1);
        System.out.println(reversePairs);
    }
}
