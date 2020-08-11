package string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/10 23:39
 * @description：给定一个字符串，逐个翻转字符串中的每个单词。
 * @modified By：
 * @version: 1.1
 */
public class question151 {
    /*
     * @Author liumt
     * @Description 使用双端队列.先去掉首尾空格,然后把单词放到队列中
     * @Date 23:39 2020/8/10
     * @Param [s]
     * @return java.lang.String
     **/
    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right && s.charAt(left) == ' ')left++;
        while(left <= right && s.charAt(right) == ' ')right--;
        Deque<String> dq = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();
        while(left <= right){
            char c = s.charAt(left);
            if(c != ' '){
                sb.append(c);
            }
            if(sb.length() > 0 && c == ' '){
                dq.offerFirst(sb.toString());
                sb.setLength(0);
            }
            left++;
        }
        dq.offerFirst(sb.toString());
        return String.join(" ", dq);
    }
}
