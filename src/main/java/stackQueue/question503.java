package stackQueue;

import java.util.Stack;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/22 13:01
 * @description：下一个更大元素2
 * @modified By：
 * @version: 1.1
 */
public class question503 {
    /**
     * @Author liumt
     * @Description 两次遍历环形链表
     * @Date 13:01 2020/10/22
     * @Param [nums]
     * @return int[]
     **/
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 2 * nums.length -1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i % length] >= stack.peek()){
                stack.pop();
            }
            result[i % length] = stack.isEmpty()?-1: stack.peek();
            stack.push(nums[i % length]);
        }
        return result;
    }
}
