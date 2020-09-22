package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/22 7:32
 * @description：给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * @modified By：
 * @version: 1.1
 */
public class question494 {
    private int count = 0;
    /**
     * @Author liumt
     * @Description 暴力递归所有可能
     * @Date 7:33 2020/9/22
     * @Param [nums, S]
     * @return int
     **/
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    public int calculate(int[] nums, int i, int sum, int S){
        if(i == nums.length){
            if(sum == S){
                count++;
            }
            return 0;
        }
        calculate(nums, i + 1, sum + nums[i], S);
        calculate(nums, i + 1, sum - nums[i], S);
        return 0;
    }

    /**
     * @Author liumt
     * @Description dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
     * dp[i][j]代表[0,i]区间组成和为j的方案数
     * 递推得到,j+nums代表+i,j-nums代表-i
     * dp[i][j + nums[i]] += dp[i - 1][j]
     * dp[i][j - nums[i]] += dp[i - 1][j]
     * @Date 13:06 2020/9/22
     * @Param [nums, S]
     * @return int
     **/
    public int findTargetSumWays2(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][1000 + nums[0]] = 1;
        dp[0][1000 - nums[0]] += 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = -1000; j <= 1000; j++){
                if(dp[i - 1][j + 1000] > 0){
                    dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000];
                    dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000];
                }
            }
        }
        return S > 1000?0: dp[nums.length - 1][S + 1000];
    }
}
