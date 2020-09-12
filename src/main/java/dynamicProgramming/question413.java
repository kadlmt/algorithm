package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/12 22:01
 * @description：如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * @modified By：
 * @version: 1.1
 */
public class question413 {
    /*
     * @Author liumt
     * @Description 动态规划,dp[i] = dp[i - 1] + 1;
     * @Date 22:01 2020/9/12
     * @Param [A]
     * @return int
     **/
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
}
