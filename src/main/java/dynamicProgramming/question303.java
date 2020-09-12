package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/12 21:30
 * @description：给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点
 * @modified By：
 * @version: 1.1
 */
public class question303 {
    /*
     * @Author liumt
     * @Description 动态规划: dp[i+1] = dp[i] + nums[i]
     * sum(i, j) = dp[j + 1] - dp[i]
     * @Date 21:32 2020/9/12
     * @Param
     * @return
     **/
    class NumArray {
        private int[] dp;
        public NumArray(int[] nums) {
            dp = new int[nums.length + 1];
            dp[0] = 0;
            for(int i = 0; i < nums.length; i++){
                dp[i + 1] = dp[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return dp[j + 1] - dp[i];
        }
    }
}
