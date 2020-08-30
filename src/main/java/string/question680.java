package string;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/30 23:27
 * @description：给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @modified By：
 * @version: 1.1
 */
public class question680 {
    /*
     * @Author liumt
     * @Description 双指针+贪心算法
     * @Date 23:27 2020/8/30
     * @Param [s]
     * @return boolean
     **/
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            //相等就继续移动指针
            if(l == r){
                left++;
                right--;
            }else{//不等,就开始走分支
                boolean flag1 = true;
                boolean flag2 = true;
                //左侧的指针右移一位,然后验证是否回文
                for(int i = left + 1, j = right; i < j; i++, j--){
                    if(s.charAt(i) != s.charAt(j)){
                        flag1 = false;
                        break;
                    }
                }
                //右侧的指针左移,然后验证是否回文
                for(int i = left, j = right - 1; i < j; i++, j--){
                    if(s.charAt(i) != s.charAt(j)){
                        flag2 = false;
                        break;
                    }
                }
                //满足一个就返回true
                return flag1 || flag2;
            }
        }
        return true;
    }
}
