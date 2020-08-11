package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/11 0:03
 * @description：给定一个字符串，你需要反转字符串中每个单词的字符顺序，
 * 同时仍保留空格和单词的初始顺序。
 * @modified By：
 * @version: 1.1
 */
public class question557 {

    public String reverseWords(String s) {
        List<String> list = split(s);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < list.size(); i++){
            if(i != list.size() - 1){
                sb.append(reverse(list.get(i))).append(" ");
            } else{
                sb.append(reverse(list.get(i)));
            }

        }
        return sb.toString();
    }

    public List<String> split(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right && s.charAt(left) == ' ')left++;
        while(left <= right && s.charAt(right) == ' ')right--;
        List<String> dq = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        while(left <= right){
            char c = s.charAt(left);
            if(c != ' '){
                sb.append(c);
            }
            if(sb.length() > 0 && c == ' '){
                dq.add(sb.toString());
                sb.setLength(0);
            }
            left++;
        }
        dq.add(sb.toString());
        return dq;
    }

    public String reverse(String s){
        StringBuffer sb = new StringBuffer();
        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
