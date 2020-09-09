package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/9 22:00
 * @description：斐波拉契数列
 * @modified By：
 * @version: 1.1
 */
public class question509 {
    /*
     * @Author liumt
     * @Description 最最基本的动态规划问题,
     * f(n)=f(n-1)+f(n-2)
     * @Date 22:08 2020/9/9
     * @Param [N]
     * @return int
     **/
    public int fib(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}
