package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/2 21:20
 * @description：找到数组中消失的数字
 * @modified By：
 * @version: 1.1
 */
public class question448 {
    /**
     * @Author liumt
     * @Description 散列法
     * @Date 21:20 2020/10/2
     * @Param [nums]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            hashMap.put(nums[i], 1);
        }
        for(int i = 1; i <= nums.length; i++){
            if(!hashMap.containsKey(i)){
                result.add(i);
            }
        }
        return result;
    }
}
