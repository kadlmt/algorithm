package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/14 13:09
 * @description：给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置
 * @modified By：
 * @version: 1.1
 */
public class question34 {
    public int[] searchRange(int[] nums, int target) {
        int resultLeft = -1;
        int resultRight = -1;
        resultLeft = search(nums, target);
        resultRight = search(nums, target + 1) - 1;
        if(resultLeft == nums.length || nums[resultLeft] != target) return new int[]{-1, -1};
        return new int[]{resultLeft, resultRight};
    }

    /**
     * @Author liumt
     * @Description 二分查找第一个target
     * @Date 13:11 2020/10/14
     * @Param [nums, target]
     * @return int
     **/
    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left >> 2);
            if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
