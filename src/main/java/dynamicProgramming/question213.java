package dynamicProgramming;

import java.util.Arrays;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/7 23:45
 * @description：打家劫舍二,环形数组,头尾不能同时头
 * @modified By：
 * @version: 1.1
 */
public class question213 {
    /*
     * @Author liumt
     * @Description 把一个列表拆成两个列表
     * 一个不含头,一个不含尾
     * 动态规划两个列表
     * 取两个列表的最大值
     * @Date 0:49 2020/9/8
     * @Param [nums]
     * @return int
     **/
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        return Math.max(dp(nums1), dp(nums2));
    }

    public int dp(int[] nums){
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
