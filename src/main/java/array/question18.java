package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/1 14:43
 * @description：4数之和
 * @modified By：
 * @version: 1.1
 */
public class question18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;
                        while(left < right && nums[right] == nums[right + 1]) right--;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                    } else if(sum > target){
                        right--;
                        while(left < right && nums[right] == nums[right + 1]) right--;
                    } else{
                        left++;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                    }
                }
            }
        }
        return result;
    }
}
