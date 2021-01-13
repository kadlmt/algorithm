package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/26 8:01
 * @description：单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * @modified By：
 * @version: 1.1
 */
public class question139 {
    /**
     * @Author liumt
     * @Description 动态规划,dp[i]标识字符串的前i个,能否拆分成字典中的单词
     * dp[i] = dp[j] && check(s[j, i]);
     * @Date 8:02 2020/9/26
     * @Param [s, wordDict]
     * @return boolean
     **/
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hashSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && hashSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> hashSet = new HashSet<>();
        int maxLength = 0;
        for (String str: wordDict) {
            hashSet.add(str);
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = (i - maxLength) < 0?0: (i - maxLength); j < i; j++) {
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
