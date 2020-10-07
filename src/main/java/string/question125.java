package string;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/7 23:41
 * @description：给定一个字符串，验证它是否是回文串，
 * 只考虑字母和数字字符，可以忽略字母的大小写。
 * @modified By：
 * @version: 1.1
 */
public class question125 {
    /*
     * @Author liumt
     * @Description 双指针解法,不是最优解
     * @Date 23:51 2020/8/7
     * @Param [s]
     * @return boolean
     **/
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        int left = 0;
        int right = sb.length() - 1;
        while(left < right){
            if(sb.charAt(left) != sb.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * @Author liumt
     * @Description 原地双指针
     * @Date 8:46 2020/10/7
     * @Param [s]
     * @return boolean
     **/
    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
