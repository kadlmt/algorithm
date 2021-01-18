package dynamicProgramming;

/**
 * @author liumt
 * @date Created in 2021/1/18 12:51
 * 最长递增子序列
 */
public class question300 {
    /**
     * 动态规划 dp[i] = math.max(dp[j]) j < i;
     * dp[i]代表字符串长度为i + 1的最长子序列长度
     * 时间复杂度:O(n^2)
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
