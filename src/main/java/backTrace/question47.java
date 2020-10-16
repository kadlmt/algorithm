package backTrace;

import java.util.*;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/16 17:44
 * @description：重复数组,全排列
 * @modified By：
 * @version: 1.1
 */
public class question47 {
    List<List<Integer>> res = new ArrayList<>();
    //访问过的元素
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        //已选择
        List<Integer> trace = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backTrace(nums, 0, trace);
        return res;
    }

    public void backTrace(int[] nums, int idx, List<Integer> trace){
        if(trace.size() == nums.length){
            res.add(new ArrayList<>(trace));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            //判断重复,剪枝操作,画图理解
            //nums[i - 1]没使用过,nums[i]和nums[i - 1]相等,搜索结果肯定相等,需要剪枝
            if(vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) continue;
            vis[i] = true;
            trace.add(nums[i]);
            backTrace(nums, idx + 1, trace);
            trace.remove(idx);
            vis[i] = false;
        }
    }
}
