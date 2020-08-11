package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/12 0:50
 * @description：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @modified By：
 * @version: 1.1
 */
public class question283 {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        //记录非0的个数
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for(int i = j; i < length; i++){
            nums[i] = 0;
        }
    }
}
