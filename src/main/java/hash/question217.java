package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 12:23
 * @description：给定一个整数数组，判断是否存在重复元素
 * @modified By：
 * @version: 1.1
 */
public class question217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])) return true;
            hashMap.put(nums[i], 1);
        }
        return false;
    }
}
