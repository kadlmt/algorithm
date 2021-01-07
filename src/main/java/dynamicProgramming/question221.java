package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/26 8:37
 * @description：最大正方形,在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * @modified By：
 * @version: 1.1
 */
public class question221 {
    /**
     * @Author liumt
     * @Description dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1
     * dp[i][j]以(i,j)为右下角,组成正方形的最大边长
     * @Date 8:38 2020/9/26
     * @Param [matrix]
     * @return int
     **/
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1],
                                Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                } else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxSide * maxSide;
    }

    /**
     * 第二遍
     */
    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = 0;
        int max = -1;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == '0') dp[i][0] = 0;
            else dp[i][0] = 1;
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 0; i < column; i++) {
            if (matrix[0][i] == '0') dp[0][i] = 0;
            else dp[0][i] = 1;
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
