package matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/4 10:47
 * @description：托普利茨矩阵
 * @modified By：
 * @version: 1.1
 */
public class question766 {
    /**
     * @Author liumt
     * @Description i - j相同的在同一个对角线,比较同一对角线是否相等
     * @Date 11:00 2020/10/4
     * @Param [matrix]
     * @return boolean
     **/
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(!hashMap.containsKey(i - j)){
                    hashMap.put(i - j, matrix[i][j]);
                }else if(hashMap.get(i - j) != matrix[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
