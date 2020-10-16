package backTrace;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/16 17:01
 * @description：无重复数组,全排列
 * @modified By：
 * @version: 1.1
 */
public class question46 {
    List<List<Integer>> res = new ArrayList<>();
    /**
     * @Author liumt
     * @Description 回溯算法
     * @Date 17:25 2020/10/16
     * @Param [nums]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> permute(int[] nums) {
        //保存路径
        Deque<Integer> trace = new LinkedList<>();
        backTrace(nums, trace);
        return res;
    }

    public void backTrace(int[] nums, Deque<Integer> trace){
        //结束条件
        if(trace.size() == nums.length){
            res.add(new LinkedList<>(trace));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            //该路径选择过了
            if(trace.contains(nums[i])) continue;
            //选择
            trace.add(nums[i]);
            //进入下一层决策树
            backTrace(nums, trace);
            //取消选择
            trace.removeLast();
        }
    }
}
