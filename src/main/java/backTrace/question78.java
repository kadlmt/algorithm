package backTrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/20 19:42
 * @description：求一个数组的子集的个数
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集
 * @modified By：
 * @version: 1.1
 */
public class question78 {
    /**
     * @Author liumt
     * @Description 
     * @Date 19:43 2020/9/20
     * @Param [nums]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        //数组的每一个元素都有出现,不出现两种情况,所以子集就有2的nums.length次方的子集
        for(int i = 0; i < (1 << nums.length); i++){
            t.clear();
            //判断这个二进制数组,分别在哪些bit位上的数字为1,就添加到集合中
            for(int j = 0; j < nums.length; j++){
                if(((i >> j) & 1) == 1) t.add(nums[j]);
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }
}
