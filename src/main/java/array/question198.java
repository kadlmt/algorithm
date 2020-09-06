package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/7 0:08
 * @description：打家劫舍,如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * @modified By：
 * @version: 1.1
 */
public class question198 {
    /*
     * @Author liumt
     * @Description 动态规划
     * dp[2] = Math.max(dp[1], dp[0] + nums[1]
     * @Date 0:09 2020/9/7
     * @Param [nums]
     * @return int
     **/
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[length];
    }
}
