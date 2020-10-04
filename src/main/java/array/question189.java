package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/14 0:11
 * @description：旋转数组
 * @modified By：
 * @version: 1.1
 */
public class question189 {
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

    /**
     * @Author liumt
     * @Description 原地三次反转
     * @Date 20:45 2020/10/3
     * @Param [nums, k]
     * @return void
     **/
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
