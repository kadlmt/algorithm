package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/30 12:37
 * @description：最长和谐子序列
 * @modified By：
 * @version: 1.1
 */
public class question594 {
    /**
     * @Author liumt
     * @Description 两次遍历
     * @Date 12:37 2020/10/30
     * @Param [nums]
     * @return int
     **/
    public int findLHS(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int res = 0;
        for(int num: nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for(int num: hashMap.keySet()) {
            if(hashMap.containsKey(num + 1)){
                res = Math.max(res, hashMap.get(num) + hashMap.get(num + 1));
            }
        }
        return res;
    }
}
