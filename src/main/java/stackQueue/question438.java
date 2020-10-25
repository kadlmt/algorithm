package stackQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/25 12:50
 * @description：给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * @modified By：
 * @version: 1.1
 */
public class question438 {
    /**
     * @Author liumt
     * @Description 滑动窗口
     * @Date 13:07 2020/10/25
     * @Param [s, p]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[128];
        int[] window = new int[128];
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i < p.length(); i++){
            need[p.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            window[c]++;
            if(need[c] > 0 && window[c] <= need[c]) valid++;
            while(right - left + 1 >= p.length()){
                char c2 = s.charAt(left);
                if(valid == p.length()) result.add(left);
                if(need[c2] > 0 && window[c2] <= need[c2]) valid--;
                window[c2]--;
                left++;
            }
            right++;
        }
        return result;
    }
}
