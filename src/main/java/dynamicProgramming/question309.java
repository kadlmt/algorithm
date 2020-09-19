package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/19 11:12
 * @description：买卖股票的最佳时期,含冷冻期
 * @modified By：
 * @version: 1.1
 */
public class question309 {
    /**
     * @Author liumt
     * @Description 动态规划
     * dp[i]当天结束最大收益
     * dp[i][0]当天结束,持有股票的状态的最大收益
     * dp[i][1]当天结束,不持有股票冷冻期状态的最大收益
     * dp[i][2]当天结束,不持有股票非冷冻期状态的最大收益
     * 状态转移方程:
     * 前一天持有的股票,或者当天买入的
     * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
     * 今天卖出去了,且前一天一定要有股票
     * dp[i][1] = dp[i - 1][0] + prices[i];
     * 前一天一定没有股票,但是前一天可能是冷冻期或非冷冻期
     * dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
     * @Date 11:13 2020/9/19
     * @Param [prices]
     * @return int
     **/
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 0) return 0;
        int length = prices.length;
        int[][] dp = new int[length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i = 1; i < length; i++){
            //dp[i][0],当天结束持有股票.两种情况:
            //1.前一天买的股票 2.今天买的股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            //dp[i][1],当天结束无股票且冷冻期
            //前一天必须持有股票,今天卖
            dp[i][1] = dp[i - 1][0] + prices[i];
            //dp[i][2],当天结束无股票且无冷冻期
            //1.前一天无股票冷冻期 2.前一天无股票无冷冻期
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(Math.max(dp[length - 1][0], dp[length - 1][1]), dp[length - 1][2]);
    }
}
