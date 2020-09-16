package stackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/21 23:54
 * @description：下一个更大元素
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * @modified By：
 * @version: 1.1
 */
public class question496 {
    /**
     * @Author liumt
     * @Description 维护一个单调栈
     * 我们只需要找出nums2中每个元素对应的下一个最大元素,放入hashmap
     * @Date 23:55 2020/8/21
     * @Param [nums1, nums2]
     * @return int[]
     **/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int num: nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                hashMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while(!stack.isEmpty()){
            hashMap.put(stack.pop(), -1);
        }
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = hashMap.get(nums1[i]);
        }
        return result;
    }
}
