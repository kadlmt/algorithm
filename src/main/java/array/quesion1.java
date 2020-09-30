package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/11 16:48
 * @description：给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * @modified By：
 * @version: 1.1
 */
public class quesion1 {
    /*
     * @Author liumt
     * @Description 两遍hash表
     * @Date 17:59 2020/8/11
     * @Param [nums, target]
     * @return int[]
     **/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int v = target - nums[i];
            if(map.containsKey(v) && map.get(v) != i){
                return new int[]{i,map.get(v)};
            }
        }
        return null;
    }

    /**
     * @Author liumt
     * @Description 一遍hash表
     * @Date 16:23 2020/9/30
     * @Param [nums, target]
     * @return int[]
     **/
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(hashMap.containsKey(temp)){
                return new int[]{i, hashMap.get(temp)};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
