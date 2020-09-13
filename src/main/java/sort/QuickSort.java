package sort;

import java.util.Arrays;

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
    public static void quicklysort(int[] nums, int startIndex, int endIndex) {
        //递归结束条件
        if(startIndex >= endIndex) return ;
        //获取基准元素
        int pivotIndex = partition2(nums, startIndex, endIndex);
        //根据基准元素,进行分区递归排序
        quicklysort(nums, startIndex, pivotIndex - 1);
        quicklysort(nums, pivotIndex + 1, endIndex);
    }

    //双边循环法
    public static int partition(int[] nums, int startIndex, int endIndex){
        int pivot = nums[startIndex];
        int left = startIndex;
        int right = endIndex;
        while(left != right){
            //先移动右指针
            while(left < right && nums[right] >= pivot){
                right--;
            }
            //再移动左指针
            while(left < right && nums[left] <= pivot){
                left++;
            }
            //交换左右指针
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        //交换pivot和重合指针
        nums[startIndex] = nums[left];
        nums[left] = pivot;
        return left;
    }

    //单边循环
    public static int partition2(int[] nums, int startIndex, int endIndex){
        int pivot = nums[startIndex];
        int mark = startIndex;
        for(int i = startIndex + 1; i <= endIndex; i++){
            while(nums[i] < pivot){
                mark++;
                int temp = nums[mark];
                nums[mark] = nums[i];
                nums[i] = temp;
            }
        }
        nums[startIndex] = nums[mark];
        nums[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,4,6,5,3,2,8,1};
        quicklysort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
