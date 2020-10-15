package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/15 21:05
 * @description：搜索旋转排序数组
 * @modified By：
 * @version: 1.1
 */
public class question33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left >> 1);
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]){//前半部分有序
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            } else{//后半部分有序
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
