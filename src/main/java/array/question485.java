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
        int sum = 0;
        int temp = 0;
        int i = 0;
        while(i < nums.length){
            if(nums[i] == 1)temp++;
            if(nums[i] == 0){
                sum = Math.max(temp, sum);
                temp = 0;
            }
            i++;
        }
        return Math.max(temp, sum);
    }
}
