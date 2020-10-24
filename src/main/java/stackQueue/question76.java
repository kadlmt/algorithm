package stackQueue;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/24 13:25
 * @description：最小覆盖子串
 * @modified By：
 * @version: 1.1
 */
public class question76 {
    /**
     * @Author liumt
     * @Description 滑动窗口
     * @Date 13:34 2020/10/24
     * @Param [s, t]
     * @return java.lang.String
     **/
    public String minWindow(String s, String t) {
        //需要的字符串的个数
        int[] need = new int[128];
        //窗口字符串的个数
        int[] window = new int[128];
        String res = "";
        for(int i = 0; i < t.length(); i++){
            need[t.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        //满足条件的个数
        int valid = 0;
        //最小长度
        int min = s.length();
        while(right < s.length()){
            //即将进入的字符
            char c = s.charAt(right);
            window[c]++;
            //该字符,是需要的字符,并且数量不超过需要的数量
            if(need[c] > 0 && window[c] <= need[c]) valid++;
            //当前窗口符合条件,开始缩小窗口
            while(valid == t.length()){
                //记录该窗口子串
                if(right - left + 1 <= min){
                    res = s.substring(left, right + 1);
                    min = right - left + 1;
                }
                //左指针开始右移
                if(need[s.charAt(left)] > 0 && window[s.charAt(left)] <= need[s.charAt(left)]) valid--;
                window[s.charAt(left)]--;
                left++;
            }
            right++;
        }
        return res;
    }

}
