package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/10 19:08
 * @description：最短路径问题
 * @modified By：
 * @version: 1.1
 */
public class question64 {
    /*
     * @Author liumt
     * @Description 动态规划,dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
     * @Date 19:08 2020/9/10
     * @Param [grid]
     * @return int
     **/
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int coloums = grid[0].length;
        int[][] dp = new int[rows][coloums];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < rows; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < coloums; i++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < coloums; j++){
                int a = dp[i - 1][j] + grid[i][j];
                int b = dp[i][j - 1] + grid[i][j];
                dp[i][j] = Math.min(a, b);
            }
        }
        return dp[rows - 1][coloums - 1];
    }

    /**
     * 空间优化
     */
    public int minPathSum2(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[] dp = new int[column];
        dp[0] = grid[0][0];
        for (int i = 1; i < column; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < column; j++) {
                int a = dp[j - 1] + grid[i][j];
                int b = dp[j] + grid[i][j];
                dp[j] = Math.min(a, b);
            }
        }
        return dp[column - 1];
    }
}
