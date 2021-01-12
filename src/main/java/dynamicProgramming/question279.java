package dynamicProgramming;

/**
 * @author liumt
 * @date Created in 2021/1/11 12:40
 * 完全平方数
 */
public class question279 {
    /**
     * 动态规划dp[i] = min(dp[i - 1], dp[i - 4], dp[i - 9].......);
     * i代表给定的数字,dp[i]:组成和的完全平方数的最少个数
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
