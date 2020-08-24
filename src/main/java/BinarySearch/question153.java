package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/24 23:38
 * @description：( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * @modified By：
 * @version: 1.1
 */
public class question153 {
    /*
     * @Author liumt
     * @Description 二分法,直接套公式.相比较双指针内存消耗上更小;
     * @Date 23:38 2020/8/24
     * @Param [nums]
     * @return int
     **/
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (right + left) >>> 1;
            if (nums[mid] < nums[right]) {
                // middle可能是最小值
                right = mid;
            } else {
                // middle肯定不是最小值
                left = mid + 1;
            }
        }
        return nums[left];
    }

    /*
     * @Author liumt
     * @Description 双指针解法
     * @Date 23:42 2020/8/24
     * @Param [nums]
     * @return int
     **/
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left] == nums[right]){
                return nums[left];
            }
            if(nums[left] < nums[right]){
                right--;
            }
            if(nums[left] > nums[right]){
                left++;
            }
        }
        return nums[left];
    }
}
