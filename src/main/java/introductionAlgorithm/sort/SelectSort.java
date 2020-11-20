package introductionAlgorithm.sort;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/17 23:46
 * @description：选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 * @modified By：
 * @version: 1.1
 */
public class SelectSort {
    public int[] sort( int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int k = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[k] > nums[j]) k = j;
            }
            if(k != i){
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}
