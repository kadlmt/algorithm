package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/3 10:16
 * @description：数组的嵌套
 * @modified By：
 * @version: 1.1
 */
public class question565 {
    /**
     * @Author liumt
     * @Description 枚举出每个i,可以组成的s[i]的最大长度.时间复杂度O(n^2);
     * 时间复杂度过高
     * @Date 10:16 2020/10/3
     * @Param [nums]
     * @return int
     **/
    public int arrayNesting(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int start = nums[i];
            int count = 0;
            do{
                start = nums[start];
                count++;
            } while(start != nums[i]);
            res = Math.max(res, count);
        }
        return res;
    }

    /**
     * @Author liumt
     * @Description 可以理解为多个圆环,求最长的圆环.不同的圆环存在相同的元素
     * 时间复杂度n,空间复杂度n
     * @Date 10:51 2020/10/3
     * @Param [nums]
     * @return int
     **/
    public int arrayNesting2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            int start = nums[i];
            while(!set.contains(start)){
                set.add(start);
                count++;
                start = nums[start];
            }
            result = Math.max(result, count);
        }
        return result;
    }

    /**
     * @Author liumt
     * @Description 不使用额外空间,直接在数组上修改访问过的元素为-1
     * @Date 11:03 2020/10/3
     * @Param [nums]
     * @return int
     **/
    public int arrayNesting3(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            int k = i;
            while(nums[k] != -1){
                count++;
                int temp = k;
                k = nums[k];
                nums[temp] = -1;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
