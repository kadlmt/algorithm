package matrix;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/5 21:54
 * @description：搜索矩阵
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列
 * @modified By：
 * @version: 1.1
 */
public class question240 {
    /**
     * @Author liumt
     * @Description 从左下角为起点,target大于该位置,column++;target小于该位置,row--;
     * @Date 21:55 2020/10/5
     * @Param [matrix, target]
     * @return boolean
     **/
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0) return false;
        int row = matrix.length - 1;
        int column = 0;
        while(row >= 0 && column < matrix[0].length){
            if(matrix[row][column] < target){
                column++;
            }else if(matrix[row][column] > target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }
}
