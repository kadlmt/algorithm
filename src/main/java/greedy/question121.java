package greedy;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/18 13:00
 * @description：买卖股票的最佳时机
 * @modified By：
 * @version: 1.1
 */
public class question121 {
    /**
     * @Author liumt
     * @Description 每次记录历史最低价格,后续的比较都相对于最低价格比较收益
     * @Date 13:00 2020/9/18
     * @Param [prices]
     * @return int
     **/
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1) return 0;
        //历史最低价
        int minPrice = prices[0];
        //最高收益
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > minPrice){
                //当前价格大于历史最低价,卖出算收益
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            } else{
                //更换历史最低价
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
