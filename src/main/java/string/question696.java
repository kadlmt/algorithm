package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/10 23:16
 * @description：给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 * @version: 1.1
 */
public class question696 {
    /*
     * @Author liumt
     * @Description 我们只要遍历所有相邻的数对，求它们的贡献总和，即可得到答案。
     * @Date 23:16 2020/8/10
     * @Param [s]
     * @return int
     **/
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();
        int n = s.length();
        int left = 0;
        while(left < n){
            char c = s.charAt(left);
            int count = 0;
            while(left < n && c == s.charAt(left)){
                left++;
                count++;
            }
            counts.add(count);
        }
        int result = 0;
        for(int i = 0; i < counts.size() - 1; i++){
            result += Math.min(counts.get(i), counts.get(i + 1));
        }
        return result;
    }
}
