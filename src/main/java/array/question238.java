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
        int[] left = new int[length];
        int[] right = new int[length];
        int[] result = new int[length];
        left[0] = nums[0];
        right[length - 1] = nums[length - 1];
        for(int i = 1; i < length; i++){
            left[i] = left[i - 1] * nums[i];
        }
        for(int i = length - 2; i >= 0; i--){
            right[i] = right[i + 1] * nums[i];
        }
        for(int i = 0; i < length; i++){
            if(i == 0){
                result[i] = right[i + 1];
                continue;
            }
            if(i == length - 1){
                result[i] = left[i - 1];
                continue;
            }
            result[i] = left[i - 1] * right[i + 1];
        }
        return result;
    }

    /**
     * @Author liumt
     * @Description 不借助额外的空间
     * @Date 10:44 2020/10/4
     * @Param [nums]
     * @return int[]
     **/
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int result[] = new int[length];
        result[0] = nums[0];
        //先使用结果数组,存放左边的乘积
        for(int i = 1; i < length; i++){
            result[i] = result[i - 1] * nums[i];
        }
        int R = 1;
        //使用左边的乘积*右边的乘积放在结果数组
        for(int i = length - 1; i >= 0; i--){
            if(i > 0){
                result[i] = result[i - 1] * R;
            } else{
                result[i] = R;
            }
            R *= nums[i];
        }
        return result;
    }
}
