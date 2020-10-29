package hash;

import java.util.TreeSet;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 12:41
 * @description：在整数数组 nums 中，是否存在两个下标 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，
 * 且满足 i 和 j 的差的绝对值也小于等于 ķ 。
 * @modified By：
 * @version: 1.1
 */
public class question220 {
    /**
     * @Author liumt
     * @Description 二叉搜索树
     * @Date 12:41 2020/10/29
     * @Param [nums, k, t]
     * @return boolean
     **/
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            //查询比nums[i]大的最小值
            Long c = set.ceiling((long)nums[i]);
            if(c != null && c <= (long)nums[i] + t) return true;
            //查询比nums[i]小的最大值
            Long f = set.floor((long)nums[i]);
            if(f != null && (long)nums[i] <= f + t) return true;
            set.add((long)nums[i]);
            if(set.size() > k){
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
