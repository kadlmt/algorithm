package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/31 23:28
 * @description：反转字符串中的元音字母
 * @modified By：
 * @version: 1.1
 */
public class question345 {
    public String reverseVowels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);
        map.put('A', 1);
        map.put('E', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('U', 1);
        int left = 0;
        int right = s.length() - 1;
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        while(left < right){
            if(map.containsKey(c[left]) && map.containsKey(c[right])){
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
                continue;
            }
            if(!map.containsKey(c[left])){
                left++;
            }
            if(!map.containsKey(c[right])){
                right--;
            }
        }
        for(char ch: c){
            sb.append(ch);
        }
        return sb.toString();
    }
}
