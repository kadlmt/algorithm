package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/24 19:47
 * @description：零钱兑换
 * @modified By：
 * @version: 1.1
 */
public class question322 {
    /**
     * @Author liumt
     * @Description 自顶向下,F(amount)= min(F(amount - coins[i]) + 1
     * count作为备忘录,记录已经算过的F(amount)
     * @Date 19:48 2020/9/24
     * @Param [coins, amount]
     * @return int
     **/
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] count = new int[amount];
        return coinChange(coins, amount, count);
    }

    public int coinChange(int[] coins, int amount, int[] count){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(count[amount - 1] != 0) return count[amount - 1];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int res = coinChange(coins, amount - coins[i], count);
            if(res >= 0 && res < min){
                min = res + 1;
            }
        }
        count[amount - 1] = min == Integer.MAX_VALUE?-1: min;
        return count[amount - 1];
    }

    /**
     * @Author liumt
     * @Description 动态规划dp[k] = min(dp[k], dp[k- coins[i]] + 1)
     * @Date 20:51 2020/9/24
     * @Param [coins, amount]
     * @return int
     **/
    public int coinChange2(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int k = 1; k <= amount; k++){
            for(int i = 0; i < coins.length; i++){
                if(k - coins[i] >= 0){
                    dp[k] = Math.min(dp[k], dp[k - coins[i]] + 1);
                }
            }
        }
        return dp[amount] > amount?-1: dp[amount];
    }
}
