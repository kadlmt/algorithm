package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/24 23:20
 * @description：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @modified By：
 * @version: 1.1
 */
public class question35 {
    /*
     * @Author liumt
     * @Description 直接套用二分法公式
     * @Date 23:20 2020/8/24
     * @Param [nums, target]
     * @return int
     **/
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            //获取中间位置
            int mid = (left + right) >>> 1;
            //相等直接返回了
            if(nums[mid] == target){
                return mid;
            }
            //固定写法,注意边界问题
            if(target > nums[mid]){
                left = mid + 1;
            }
            //固定写法,注意边界问题
            if(target < nums[mid]){
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * @Author liumt
     * @Description 解法同上,压缩行
     * @Date 19:56 2020/10/13
     * @Param [nums, target]
     * @return int
     **/
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            //防止Integer溢出
            int mid = left + ((right - left) >> 1);
            if(target == nums[mid]) return mid;
            if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
