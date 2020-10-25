package stackQueue;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/25 13:07
 * @description：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @modified By：
 * @version: 1.1
 */
public class question3 {
    /**
     * @Author liumt
     * @Description 滑动窗口
     * @Date 13:08 2020/10/25
     * @Param [s]
     * @return int
     **/
    public int lengthOfLongestSubstring(String s) {
        int[] window = new int[128];
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            window[c]++;
            while(window[c] > 1){
                char c2 = s.charAt(left);
                window[c2]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
