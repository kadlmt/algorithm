package stackQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/23 12:31
 * @description：每日温度
 * @modified By：
 * @version: 1.1
 */
public class question739 {
    /**
     * @Author liumt
     * @Description 单调递减栈
     * @Date 12:31 2020/10/23
     * @Param [T]
     * @return int[]
     **/
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[T.length];
        for(int i = 0; i < T.length; i++){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
