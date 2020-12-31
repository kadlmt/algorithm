package dynamicProgramming;

/**
 * @author liumt
 * @date Created in 2020/12/31 12:24
 * 爬楼梯,一步两步似魔鬼的步伐
 */
public class question70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }
}
