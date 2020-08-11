package string;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/9 0:28
 * @description：编写一个函数，其作用是将输入的字符串反转过来。
 * 输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * @modified By：
 * @version: 1.1
 */
public class question344 {
    /*
     * @Author liumt
     * @Description 双指针解法
     * @Date 0:34 2020/8/9
     * @Param [s]
     * @return void
     **/
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right){
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
}
