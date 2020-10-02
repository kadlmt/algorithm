package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/12 23:28
 * @description：给定一个二进制数组， 计算其中最大连续1的个数。
 * @modified By：
 * @version: 1.1
 */
public class question485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
            } else{
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}
