package introductionAlgorithm.divideAndConquer;

/**
 * @author liumt
 * @date Created in 2020/11/20 12:27
 * 最大子数组,暴力求解,习题4.2
 * O(n^2)
 */
public class FindMaxSubArray4_2 {
    public static int findMaxSubArray(int[] array) {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                maxNum = Math.max(maxNum, sum);
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] array = {13, -3, -25, 20, -3, -16, -23,
                18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(findMaxSubArray(array));
    }
}
