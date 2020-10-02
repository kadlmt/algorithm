package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/2 21:32
 * @description：找到所有出现两次的元素
 * @modified By：
 * @version: 1.1
 */
public class question442 {
    /**
     * @Author liumt
     * @Description 散列法
     * @Date 21:32 2020/10/2
     * @Param [nums]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                result.add(nums[i]);
            } else{
                hashMap.put(nums[i], 1);
            }
        }
        return result;
    }
}
