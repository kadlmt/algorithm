package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/19 11:46
 * @description：买卖股票的最佳时期,含手续费
 * @modified By：
 * @version: 1.1
 */
public class question714 {
    /**
     * @Author liumt
     * @Description 两个状态,当天结束不持有股票的最大收益和当天结束持有股票的最大收益
     * @Date 11:48 2020/9/19
     * @Param [prices, fee]
     * @return int
     **/
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length <= 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++){
            //当天持有股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //当天不持有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
