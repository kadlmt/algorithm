package string;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/7 10:09
 * @description：回文数
 * @modified By：
 * @version: 1.1
 */
public class question9 {
    /**
     * @Author liumt
     * @Description 转成字符串
     * @Date 10:10 2020/10/7
     * @Param [x]
     * @return boolean
     **/
    public boolean isPalindrome(int x) {
        String s = x + "";
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * @Author liumt
     * @Description 反转一半的数字,x为前半段,reverseNum为后半段的反转
     * @Date 10:18 2020/10/7
     * @Param [x]
     * @return boolean
     **/
    public boolean isPalindrome2(int x) {
        int reverseNum = 0;
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        while(x > reverseNum){
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return (x == reverseNum) || (x == reverseNum / 10);
    }
}
