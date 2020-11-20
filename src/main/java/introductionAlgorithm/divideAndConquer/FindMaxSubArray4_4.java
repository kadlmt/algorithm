package introductionAlgorithm.divideAndConquer;

/**
 * @author liumt
 * @date Created in 2020/11/20 12:44
 * 最大子数组问题,允许返回空数组
 * 只需要在返回值判断,值是否>0就行
 */
public class FindMaxSubArray4_4 {
    /**
     * 暴力算法
     * @param array
     * @return
     */
    public static int findMaxSubArray(int[] array) {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                maxNum = Math.max(maxNum, sum);
            }
        }
        return maxNum > 0?maxNum: 0;
    }

    /**
     * 最大子数组递归算法
     */
    public static int findMaxSubArray(int[] array, int low, int high) {
        if (low == high) return array[low];
        int mid = (low + high) / 2;
        int leftMax = findMaxSubArray(array, low, mid);
        int rightMax = findMaxSubArray(array, mid + 1, high);
        int crossMax = findMaxCrossSubArray(array, low, mid, high);
        return Math.max(Math.max(leftMax, rightMax), crossMax) > 0?Math.max(Math.max(leftMax, rightMax), crossMax): 0;
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
        int[] array = {-13, -3, -25, -20, -3, -16, -23,
                -18, -20, -7, -12, -5, -22, -15, -4, -7};
        System.out.println(findMaxSubArray(array));
        System.out.println(findMaxSubArray(array, 0, array.length - 1));
    }
}
