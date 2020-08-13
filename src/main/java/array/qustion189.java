package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/14 0:11
 * @description：旋转数组
 * @modified By：
 * @version: 1.1
 */
public class qustion189 {
    /*
     * @Author liumt
     * @Description 使用额外的数组
     * @Date 0:11 2020/8/14
     * @Param [nums, k]
     * @return void
     **/
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[(i + k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = result[i];
        }
    }
}
