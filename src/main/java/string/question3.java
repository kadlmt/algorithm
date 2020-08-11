package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/10 0:06
 * @description：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @modified By：
 * @version: 1.1
 */
public class question3 {
    /*
     * @Author liumt
     * @Description 使用双指针,做一个通道.左指针右移的时候,set移出指针前一个数据
     * 右指针不断右移,直到出现重复数据.
     * 不是最优解
     * @Date 0:07 2020/8/10
     * @Param [s]
     * @return int
     **/
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();
        int right = -1;
        int length = s.length();
        int ans = 0;
        for(int i = 0; i < length; i++){
            if(i != 0){
                hashSet.remove(s.charAt(i - 1));
            }
            while(right + 1 < length && !hashSet.contains(s.charAt(right + 1))){
                hashSet.add(s.charAt(++right));
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }
}
