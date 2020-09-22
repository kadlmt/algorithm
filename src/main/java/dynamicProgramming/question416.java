package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/21 13:29
 * @description：分割等和子集,给定一个只包含正整数的非空数组。
 * 是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @modified By：
 * @version: 1.1
 */
public class question416 {
    /**
     * @Author liumt
     * @Description 状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
     * 状态转移方程：当前考虑到的数字选与不选」。
     * 不选择 nums[i]，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
     * 选择 nums[i]，如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]。
     * dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]
     * 特殊情况:nums[i] = j ,dp[i][j] = true;
     * @Date 13:30 2020/9/21
     * @Param [nums]
     * @return boolean
     **/
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length <= 0) return false;
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if((sum & 1) != 0) return false;
        int target = sum >> 1;
        boolean[][] dp = new boolean[nums.length][target + 1];
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = dp[i - 1][j];
                if(nums[i] == j){
                    dp[i][j] = true;
                }
                if(nums[i] < j){
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}
