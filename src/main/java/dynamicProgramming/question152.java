package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/26 9:33
 * @description：给你一个整数数组 nums ，
 * 请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积
 * @modified By：
 * @version: 1.1
 */
public class question152 {
    /**
     * @Author liumt
     * @Description dp[i][0]表示前i个,对应的最大值;dp[i][1]表示前i个,对应的最小值
     * @Date 9:36 2020/9/26
     * @Param [nums]
     * @return int
     **/
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0] * nums[i],
                    Math.max(nums[i], dp[i - 1][1] * nums[i]));
            dp[i][1] = Math.min(dp[i - 1][0] * nums[i],
                    Math.min(nums[i], dp[i - 1][1] * nums[i]));
        }
        int max = dp[0][0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}
