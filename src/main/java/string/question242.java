package string;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/6 23:43
 * @description：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @modified By：
 * @version: 1.1
 */
public class question242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int a: count){
            if(a != 0)return false;
        }
        return true;
    }
}
