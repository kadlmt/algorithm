package introductionAlgorithm.select;

import java.util.Random;

/**
 * @author liumt
 * @date Created in 2020/12/19 13:16
 * 选择算法主要是用来解决第k大问题
 * 顺序统计量: 第k小的元素
 * 中位数: 位于数组中间的数;奇数唯一,偶数两个
 */
public class Select {
    /**
     * 选择最小的数
     */
    public static int findMin(int[] array) {
        if (array == null || array.length <= 0)
            return -1;
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    /**
     * 选择最大的数
     */
    public static int findMax(int[] array) {
        if (array == null || array.length <= 0)
            return -1;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    /**
     * 同时选择最大和最小数
     */
    public static MinMaxPair findMinMax(int[] array) {
        if (array == null || array.length <= 0)
            return new MinMaxPair();
        // 奇数处理
        int min = array[0];
        int max = array[0];
        int i = 1;
        // 偶数处理
        if (array.length % 2 == 0) {
           i = 2;
           max = array[1];
           if (array[0] > array[1]) {
               int temp = min;
               min = max;
               max = temp;
           }
        }
        // 每次取出两个数
        for (; i < array.length; i += 2) {
            int minTemp = array[i];
            int maxTemp = array[i + 1];
            if (array[i] > array[i + 1]) {
                int temp = minTemp;
                minTemp = maxTemp;
                maxTemp = temp;
            }
            if (minTemp < min)
                min = minTemp;
            if (maxTemp > max)
                max = maxTemp;
        }
        return new MinMaxPair(min, max);
    }

    /**
     * 快速选择,第i顺序统计量
     * 基于快排主元的思想
     * 假设元素互异,在期望线性时间内找到任一顺序统计量
     * 递归解法
     **/
    public static int randomSelect(int[] array, int p, int r, int i) {
        if (p == r)
            return array[p];
        int q = randomPatition(array, p, r);
        int k = q - p + 1;
        if (i == k) return array[q];
        else if (i < k) return randomSelect(array, p, q - 1, i);
        else return randomSelect(array, q + 1, r, i - k);
    }

    /**
     * 迭代写法
     */
    public static int randomSelect2(int[] array, int p, int r, int i) {
        while (true) {
            if (p == r) return array[p];
            int q = randomPatition(array, p, r);
            int k = q - p + 1;
            if (i == k) return array[q];
            else if (i < k) {
                r = q - 1;
            } else {
                p = q + 1;
                i = i - k;
            }
        }
    }

    /**
     * 随机快排的主元
     */
    public static int randomPatition(int[] array, int p, int r) {
        Random random = new Random();
        int i = random.nextInt(r - p) + p;
        int temp = array[i];
        array[i] = array[r];
        array[r] = temp;
        return patition(array, p, r);
    }

    /**
     * 快排主元
     */
    public static int patition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;
        for (int j = p; j < array.length; j++) {
            if (array[j] < x) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[r];
        array[r] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // 测试findMin
//        int[] array = new int[]{7, 2, 8, 2, 4, 9, 3, 5, 4, 1};
//        System.out.println(findMin(array));

        // 测试findMax
//        int[] array = new int[]{7, 2, 8, 2, 4, 9, 3, 5, 4, 1};
//        System.out.println(findMax(array));

        // 测试findMinMax
//        int[] array = new int[]{7, 2, 8, 33, 2, 4, 9, 3, 5, 4, 1};
//        MinMaxPair minMaxPair = findMinMax(array);
//        System.out.println(minMaxPair);

        // 寻找第i小元素,递归模式
//        int[] array = new int[]{7, 2, 8, 2, 4, 9, 3, 5, 4, 1};
//        System.out.println(randomSelect(array, 0, array.length - 1, 5));

        // 寻找第i小元素,迭代模式
//        int[] array = new int[]{7, 2, 8, 2, 4, 9, 3, 5, 4, 1};
//        System.out.println(randomSelect2(array, 0, array.length - 1, 5));
    }
}
