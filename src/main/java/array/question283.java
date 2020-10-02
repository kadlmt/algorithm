package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/12 0:50
 * @description：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @modified By：
 * @version: 1.1
 */
public class question283 {
    /**
     * @Author liumt
     * @Description 两次循环
     * @Date 8:41 2020/10/2
     * @Param [nums]
     * @return void
     **/
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

    /**
     * @Author liumt
     * @Description 一次循环,利用快排的思想,左边是非0,右边是0
     * @Date 8:41 2020/10/2
     * @Param [nums]
     * @return void
     **/
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
