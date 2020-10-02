package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/12 23:44
 * @description：集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
 * 导致集合丢失了一个整数并且有一个元素重复。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，
 * 再找到丢失的整数，将它们以数组的形式返回。
 * @modified By：
 * @version: 1.1
 */
public class question645 {
    /*
     * @Author liumt
     * @Description 借助hash表
     * @Date 23:45 2020/8/12
     * @Param [nums]
     * @return int[]
     **/
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int a = 0;
        int b = 0;
        for(int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                a = nums[i];
            }
            hashMap.put(nums[i], 1);
        }
        for(int i = 1; i <= nums.length; i++){
            if(!hashMap.containsKey(i)){
                b = i;
            }
        }
        return new int[]{a, b};
    }
}
