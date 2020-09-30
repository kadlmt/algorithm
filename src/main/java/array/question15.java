package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/30 17:42
 * @description：三数之和为0,去重复
 * @modified By：
 * @version: 1.1
 */
public class question15 {
    /**
     * @Author liumt
     * @Description 排序+双指针
     * i:遍历这个数组,作为第一个数
     * left:初始为i+1,作为第二个数
     * right:初始为nums.length - 1,作为第三个数
     * 1:nums[i] = 0,则sum一定不会等于0,直接break
     * 2;nums[i] == nums[i - 1] 说明该数字重复,continue
     * 3:sum == 0,left++,right--;
     * 3.1:nums[left] == nums[left - 1]说明重复 left++
     * 3.2:nums[right] == nums[right + 1]说明重复 right--
     * 4:sum > 0; right--
     * 5.sum < 0; left++
     * @Date 17:43 2020/9/30
     * @Param [nums]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left -1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                } else if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                } else{
                    left++;
                }
            }
        }
        return result;
    }
}
