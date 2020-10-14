package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/14 16:40
 * @description：二分查找target,没有返回-1;
 * @modified By：
 * @version: 1.1
 */
public class question704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left >> 1);
            if(target == nums[mid]) return mid;
            if(target >= nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
