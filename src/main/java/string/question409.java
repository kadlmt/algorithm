package string;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/30 23:50
 * @description：给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * @modified By：
 * @version: 1.1
 */
public class question409 {
    /*
     * @Author liumt
     * @Description 贪心算法
     * @Date 23:53 2020/8/30
     * @Param [s]
     * @return int
     **/
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int result = 0;
        //字母的ASCII码作为下标,值为字母出现的次数
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }
        for(int a: count){
            //字母出现的次数/2*2就是可以作为回文串的个数
            result += a / 2 * 2;
            //如果是第一次出现奇数,则可以当做中心位置
            if((a & 1) == 1 && (result & 1) == 0){
                result++;
            }
        }
        return result;
    }
}
