package sort;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/17 23:41
 * @description：冒泡排序
 * @modified By：
 * @version: 1.1
 */
public class BubbleSort {
    public int[] bubblingSort( int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
