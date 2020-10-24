package stackQueue;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/24 21:09
 * @description：字符串的排列
 * @modified By：
 * @version: 1.1
 */
public class question567 {
    /**
     * @Author liumt
     * @Description 滑动窗口
     * @Date 21:09 2020/10/24
     * @Param [s1, s2]
     * @return boolean
     **/
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[128];
        int[] window = new int[128];
        for(int i = 0; i < s1.length(); i++){
            need[s1.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while(right < s2.length()){
            char c = s2.charAt(right);
            window[c]++;
            if(need[c] > 0 && window[c] <= need[c]){
                valid++;
            }
            while(right - left + 1 >= s1.length()){
                char c2 = s2.charAt(left);
                if(valid == s1.length()) return true;
                if(need[c2] > 0 && window[c2] <= need[c2]) valid--;
                window[c2]--;
                left++;
            }
            right++;
        }
        return false;
    }
}
