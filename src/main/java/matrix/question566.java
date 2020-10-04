package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/4 18:38
 * @description：重塑矩阵
 * @modified By：
 * @version: 1.1
 */
public class question566 {
    /**
     * @Author liumt
     * @Description 借助队列
     * @Date 18:39 2020/10/4
     * @Param [nums, r, c]
     * @return int[][]
     **/
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int columns = nums[0].length;
        if(r * c != rows * columns) return nums;
        Queue<Integer> queue = new LinkedList<>();
        int[][] result = new int[r][c];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                queue.offer(nums[i][j]);
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                result[i][j] = queue.poll();
            }
        }
        return result;
    }

    /**
     * @Author liumt
     * @Description 不借用额外的空间
     * @Date 18:42 2020/10/4
     * @Param
     * @return
     **/
    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int rows = nums.length;
        int columns = nums[0].length;
        if(r * c != rows * columns) return nums;
        int[][] result = new int[r][c];
        int row = 0;
        int col = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                //遍历原始矩阵的时候就放入结果矩阵中
                result[row][col] = nums[i][j];
                col++;
                //该行已经放满元素,切换到下一行,列清0
                if(col == c){
                    row++;
                    col = 0;
                }
            }
        }
        return result;
    }

    /**
     * @Author liumt
     * @Description count为当前遍历元素的个数,count / c 确定行数,count % c确定列
     * @Date 18:49 2020/10/4
     * @Param [nums, r, c]
     * @return int[][]
     **/
    public int[][] matrixReshape3(int[][] nums, int r, int c) {
        int rows = nums.length;
        int columns = nums[0].length;
        if(r * c != rows * columns) return nums;
        int[][] result = new int[r][c];
        int count = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                result[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return result;
    }
}
