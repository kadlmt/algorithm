package introductionAlgorithm.divideAndConquer;

/**
 * @author liumt
 * @date Created in 2020/11/20 12:58
 * 最大子数组, 线性查找
 */
public class FindMaxSubArray4_5 {
    public static int findMaxSubArray(int[] array) {
        int maxNum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum + array[i] > array[i]) {
                sum += array[i];
            } else {
                sum = array[i];
            }
            maxNum = Math.max(maxNum, sum);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] array = {13, -3, -25, 20, -3, -16, -23,
                18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(findMaxSubArray(array));
    }
}
