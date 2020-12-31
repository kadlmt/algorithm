package dynamicProgramming;

/**
 * @author liumt
 * @date Created in 2020/12/31 12:38
 * 打家劫舍
 */
public class question198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[length];
    }
}
