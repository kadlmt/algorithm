package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/7 23:21
 * @description：给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
 * 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * @modified By：
 * @version: 1.1
 */
public class question205 {
    public boolean isIsomorphic(String s, String t) {
        return check(s, t) && check(t, s);
    }

    public boolean check(String s, String t){
        Map<Character, Character> hashMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(hashMap.containsKey(a)){
                if(hashMap.get(a) != b){
                    return false;
                }
            } else{
                hashMap.put(a, b);
            }
        }
        return true;
    }
}
