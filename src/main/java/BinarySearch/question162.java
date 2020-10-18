package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/18 21:10
 * @description：寻找峰值
 * @modified By：
 * @version: 1.1
 */
public class question162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left >> 1);
            if(nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
