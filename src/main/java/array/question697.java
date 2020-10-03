package array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/3 9:41
 * @description：你的任务是找到与 nums 拥有相同大小的度的最短连续子数组
 * @modified By：
 * @version: 1.1
 */
public class question697 {
    /**
     * @Author liumt
     * @Description 散列法
     * @Date 9:42 2020/10/3
     * @Param [nums]
     * @return int
     **/
    public int findShortestSubArray(int[] nums) {
        //每个元素出现的起始位置
        Map<Integer, Integer> left = new HashMap<>();
        //每个元素出现的终止位置
        Map<Integer, Integer> right = new HashMap<>();
        //每个元素出现的次数
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(count.containsKey(nums[i])){
                count.put(nums[i], count.get(nums[i]) + 1);
                right.put(nums[i], i);
            }else{
                count.put(nums[i], 1);
                left.put(nums[i], i);
                right.put(nums[i], i);
            }
        }
        int min = nums.length;
        //数组的度
        int degree = Collections.max(count.values());
        for(int key: count.keySet()){
            //找到出现次数为数组的度的元素
            if(count.get(key) == degree){
                //找到最小子数组
                min = Math.min(min, right.get(key) - left.get(key) + 1);
            }
        }
        return min;
    }
}
