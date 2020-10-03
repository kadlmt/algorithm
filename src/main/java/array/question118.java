package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/13 23:55
 * @description：杨辉三角
 * @modified By：
 * @version: 1.1
 */
public class question118 {
    /*
     * @Author liumt
     * @Description 动态规划问题,下一行等于上一行的数字和.
     * @Date 23:56 2020/8/13
     * @Param [numRows]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) return result;
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        result.add(list1);
        for(int i = 1; i < numRows; i++){
            List<Integer> pre = result.get(i - 1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for(int j = 1; j < pre.size(); j++){
                cur.add(pre.get(j) + pre.get(j - 1));
            }
            cur.add(1);
            result.add(cur);
        }
        return result;
    }
}
