package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/11 18:11
 * @description：不同的路径,有障碍物
 * @modified By：
 * @version: 1.1
 */
public class question63 {
    /*
     * @Author liumt
     * @Description 有障碍物的地方记为0,上下边界,如果左右为0,则也为0
     * @Date 18:11 2020/9/11
     * @Param [obstacleGrid]
     * @return int
     **/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        if(obstacleGrid[0][0] == 1)
            return 0;
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];
        for(int i = 0 ; i < rows; i++){
            if(obstacleGrid[i][0] == 1 || (i > 0 && dp[i - 1][0] == 0)){
                dp[i][0] = 0;
                continue;
            }
            dp[i][0] = 1;
        }
        for(int i = 0 ; i < columns; i++){
            if(obstacleGrid[0][i] == 1 || (i > 0 && dp[0][i - 1] == 0)){
                dp[0][i] = 0;
                continue;
            }
            dp[0][i] = 1;
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < columns; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
