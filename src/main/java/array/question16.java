package array;

import java.util.Arrays;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/1 10:48
 * @description：最接近的三数之和
 * @modified By：
 * @version: 1.1
 */
public class question16 {
    /**
     * @Author liumt
     * @Description 排序加双指针
     * @Date 10:48 2020/10/1
     * @Param [nums, target]
     * @return int
     **/
    public int threeSumClosest(int[] nums, int target) {
        int result = 1000000;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return sum;
                }else if(sum > target){
                    if(sum - target < Math.abs(result - target)){
                        result = sum;
                    }
                    right--;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                } else{
                    if(target - sum < Math.abs(result - target)){
                        result = sum;
                    }
                    left++;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }
        return result;
    }
}
