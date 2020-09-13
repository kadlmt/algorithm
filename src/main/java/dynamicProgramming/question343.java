package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/13 21:54
 * @description：给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积
 * @modified By：
 * @version: 1.1
 */
public class question343 {
    /*
     * @Author liumt
     * @Description 动态规划,dp[i]存放,每一个数字可以拆分的最大乘积
     * 循环获取每一个数字的可以获得的最大乘积
     * j代表从1开始,一直到n - 1
     * 最大乘积的获取 i * (i - j)和i * dp[i - j]的最大值
     * @Date 21:54 2020/9/13
     * @Param [n]
     * @return int
     **/
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++){
            int curMax = 0;
            for(int j = 1; j < i; j++){
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
