package introductionAlgorithm.divideAndConquer;

/**
 * @author liumt
 * @date Created in 2020/11/19 12:54
 * 最大子数组,递归解法,O(n*log n)
 */
public class FindMaxSubArray4_3 {
    /**
     * 最大子数组递归算法
     */
    public static int findMaxSubArray(int[] array, int low, int high) {
        if (low == high) return array[low];
        int mid = (low + high) / 2;
        int leftMax = findMaxSubArray(array, low, mid);
        int rightMax = findMaxSubArray(array, mid + 1, high);
        int crossMax = findMaxCrossSubArray(array, low, mid, high);
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    /**
     * 获得横跨mid的最大子数组
     */
    public static int findMaxCrossSubArray(int[] array, int low, int mid, int high) {
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid; i >= 0; i--) {
            leftSum += array[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid + 1; i <= high; i++) {
            rightSum += array[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return leftMax + rightMax;
    }

    public static void main(String[] args) {
        int[] array = {13, -3, -25, 20, -3, -16, -23,
                18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(findMaxSubArray(array, 0, array.length - 1));
    }
}
