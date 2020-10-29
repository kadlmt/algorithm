package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 12:27
 * @description：给定一个整数数组和一个整数 k，
 * 判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
 * 并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * @modified By：
 * @version: 1.1
 */
public class question219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i]) && i - hashMap.get(nums[i]) <= k) {
                return true;
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }
}
