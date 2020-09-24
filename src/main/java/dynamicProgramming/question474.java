package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/23 13:13
 * @description：在计算机界中，我们总是追求用有限的资源获取最大的收益。
 *
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 *
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 * @modified By：
 * @version: 1.1
 */
public class question474 {
    /**
     * @Author liumt
     * @Description dp[k][i][j] 表示遍历到第k-1k−1个字符的时候，使用ii个0，jj个1的时候，能够拼出的字符串的数量，即个数
     *
     * 转移方程
     * dp[k][i][j]= 1+dp[k-1][i-cost_zero[k]][j-cost_one[k]] i>=cost_zero[k] and j>=cost_one[k]} dp[k-1][i][j]
     * dp[k][i][j]={
     * 1+dp[k−1][i−cost_zero[k]][j−cost_one[k]]
     * dp[k−1][i][j]
     * @Date 13:16 2020/9/23
     * @Param [strs, m, n]
     * @return int
     **/
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for(int k = 1; k <= strs.length; k++){
            int[] count = counter(strs[k - 1]);
            for(int i = 0; i < m + 1; i++){
                for(int j = 0; j < n + 1; j++){
                    if(i - count[0] >= 0 && j - count[1] >= 0){
                        dp[k][i][j] = Math.max(1 + dp[k - 1][i - count[0]][j - count[1]],
                                dp[k][i][j]);
                    }
                    dp[k][i][j] = Math.max(dp[k][i][j], dp[k - 1][i][j]);
                }
            }
        }
        return dp[length][m][n];
    }

    public int[] counter(String str){
        int[] count = new int[2];
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0') count[0]++;
            else count[1]++;
        }
        return count;
    }
}
