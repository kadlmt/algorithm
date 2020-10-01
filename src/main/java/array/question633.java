package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/1 15:42
 * @description：平方数之和
 * @modified By：
 * @version: 1.1
 */
public class question633 {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while(left <= right){
            int sum = left * left + right * right;
            if(sum == c){
                return true;
            } else if(sum > c){
                right--;
            } else{
                left++;
            }
        }
        return false;
    }
}
