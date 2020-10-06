package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/6 11:50
 * @description：螺旋遍历矩阵
 * @modified By：
 * @version: 1.1
 */
public class question54 {
    /**
     * @Author liumt
     * @Description (top,left)-->(top,right)
     * (top+1,right)-->(bottom,right)
     * 判断条件left<right,top<bottom
     * (bottom,right-1)-->(bottom,left)
     * (bottom-1,left)-->(top+1,left)
     * @Date 11:51 2020/10/6
     * @Param [matrix]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList();
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = columns - 1;
        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            for(int i = top + 1; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            if(left < right && top < bottom){
                for(int i = right - 1; i >= left; i--){
                    list.add(matrix[bottom][i]);
                }
                for(int i = bottom - 1; i >= top + 1; i--){
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }
}
