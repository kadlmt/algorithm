package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/2 9:28
 * @description：删除排序数组的重复项
 * @modified By：
 * @version: 1.1
 */
public class question26 {
    public int removeDuplicates(int[] nums) {
        //非重复的个数
        int j = 0;
        for(int i = 1; i < nums.length; i++){
            //遇到非重复的,交换到j+1的位置
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
