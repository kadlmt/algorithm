package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/10 20:08
 * @description：不同的路径
 * @modified By：
 * @version: 1.1
 */
public class question62 {
    /*
     * @Author liumt
     * @Description 动态规划,dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     * @Date 20:08 2020/9/10
     * @Param [m, n]
     * @return int
     **/
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
