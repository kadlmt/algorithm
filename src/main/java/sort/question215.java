package sort;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/26 13:00
 * @description：数组中第k个最大元素
 * @modified By：
 * @version: 1.1
 */
public class question215 {
    /**
     * @Author liumt
     * @Description 快排,时间复杂度(n*log n)
     * @Date 13:01 2020/10/26
     * @Param [nums, k]
     * @return int
     **/
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        if(length <= 0) return 0;
        quickSort(nums, 0, length - 1);
        return nums[length - k];
    }

    public void quickSort(int[] nums, int startIndex, int endIndex){
        if(startIndex >= endIndex) return;
        int pivot = partition(nums, startIndex, endIndex);
        quickSort(nums, startIndex, pivot - 1);
        quickSort(nums, pivot + 1, endIndex);
    }

    public int partition(int[] nums, int startIndex, int endIndex){
        int pivot = nums[startIndex];
        int left = startIndex;
        int right = endIndex;
        while(left < right){
            while(left < right && nums[right] >= pivot) right--;
            while(left < right && nums[left] <= pivot) left ++;
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[startIndex] = nums[left];
        nums[left] = pivot;
        return left;
    }
}
