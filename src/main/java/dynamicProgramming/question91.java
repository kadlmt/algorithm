package dynamicProgramming;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/14 19:52
 * @description：给定一个只包含数字的非空字符串，请计算解码方法的总数
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * @modified By：
 * @version: 1.1
 */
public class question91 {
    /**
     * @Author liumt
     * @Description 动态规划
     * @Date 19:58 2020/9/14
     * @Param [s]
     * @return int
     **/
    public int numDecodings(String s) {
        if(s == null || s.length() <= 0){
            return 0;
        }
        int[] dp = new int[s.length()];
        char[] c = s.toCharArray();
        if(c[0] == '0'){
            return 0;
        }
        dp[0] = 1;
        //dp[i]代表的是以s[i]结尾的串,解码的个数
        //if s[i] != '0'  dp[i] = dp[i - 1] * 1
        //if s[i] + s[i-1]*10大于9,小于27,代表s[i-1]不为0,可以组合为一个字母,
        // 再加上dp[i-2]的解码个数
        for(int i = 1; i < s.length(); i++){
            if(c[i] != '0'){
                dp[i] = dp[i - 1];
            }
            int num = (c[i] - '0') + (c[i - 1] - '0') * 10;
            //这个条件能判断s[i-1]不为0
            if(num >= 10 && num < 27){
                if(i == 1){
                    dp[i]++;
                } else{
                    dp[i] = dp[i] + dp[i - 2];
                }
            }
        }
        return dp[c.length - 1];
    }

}
