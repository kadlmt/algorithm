package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/14 23:48
 * @description：给你一个长度为 n 的整数数组 nums，其中 n > 1，
 * 返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * @modified By：
 * @version: 1.1
 */
public class question238 {
    /*
     * @Author liumt
     * @Description 先从左到右拿到,拿到左边所有乘积
     * 再从右到做,拿到右边所有乘积
     * 循环左边和右边相乘,就是结果数组
     * @Date 23:48 2020/8/14
     * @Param [nums]
     * @return int[]
     **/
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        for(int i = 1;i < nums.length; i++){
            left[i] =  nums[i - 1] * left[i - 1];
        }
        right[length - 1] = 1;
        for(int i = length - 2; i >= 0; i--){
            right[i] = nums[i + 1] * right[i + 1];
        }
        for(int i = 0; i < length; i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
