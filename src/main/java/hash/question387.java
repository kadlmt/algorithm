package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/30 12:44
 * @description：字符串中的第一个唯一字符
 * @modified By：
 * @version: 1.1
 */
public class question387 {
    /**
     * @Author liumt
     * @Description 两次hash
     * @Date 12:44 2020/10/30
     * @Param [s]
     * @return int
     **/
    public int firstUniqChar(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            if(hashMap.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
