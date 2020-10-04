package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/3 20:18
 * @description：杨辉三角,返回第k行
 * @modified By：
 * @version: 1.1
 */
public class question119 {
    /**
     * @Author liumt
     * @Description 动态规划
     * @Date 20:19 2020/10/3
     * @Param [rowIndex]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        if(rowIndex < 0) return null;
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        result.add(list1);
        for(int i = 1; i <= rowIndex; i++){
            List<Integer> pre = result.get(i - 1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for(int j = 1; j < pre.size(); j++){
                cur.add(pre.get(j) + pre.get(j - 1));
            }
            cur.add(1);
            result.add(cur);
        }
        return result.get(rowIndex);
    }
}
