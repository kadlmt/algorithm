package sort;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/17 23:31
 * @description：快速排序
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * @modified By：
 * @version: 1.1
 */
public class QuickSort {
    public int[] quicklysort( int[] nums) {
        sort(nums, 0, nums.length);
        return nums;
    }

    public void sort(int[] nums, int left, int right){
        if(left >= right) return;
        int start = left;
        int end = right;
        int flag = nums[left];
        while(left < right){
            while(left < right && nums[left] < flag){
                left++;
            }
            while(left < right && nums[right] > flag){
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        int temp1 = nums[left - 1];
        nums[left - 1] = nums[start];
        nums[start] = temp1;
        sort(nums, start, left - 1);
        sort(nums, left, end);
    }
}
