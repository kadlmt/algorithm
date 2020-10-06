package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/6 14:51
 * @description：矩阵置零
 * @modified By：
 * @version: 1.1
 */
public class question73 {
    /**
     * @Author liumt
     * @Description 借助额外的空间,存放需要置零的行与列
     * @Date 14:52 2020/10/6
     * @Param [matrix]
     * @return void
     **/
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(rows.contains(i) || columns.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
