package greedy;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/18 13:28
 * @description：买卖股票的最佳时机2,可以多次买卖.买了之后,必须卖才能买
 * @modified By：
 * @version: 1.1
 */
public class question122 {
    /**
     * @Author liumt
     * @Description 峰谷法
     * @Date 13:29 2020/9/18
     * @Param [prices]
     * @return int
     **/
    public int maxProfit(int[] prices) {
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        int i = 0;
        while(i < prices.length - 1){
            //找到连续最低谷
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]){
                i++;
            }
            valley = prices[i];
            //找到连续最高峰
            while(i < prices.length - 1 && prices[i] <= prices[i + 1]){
                i++;
            }
            peak = prices[i];
            maxProfit += (peak - valley);
        }
        return maxProfit;
    }
}
