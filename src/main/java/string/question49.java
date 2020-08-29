package string;

import java.util.*;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/29 23:55
 * @description：字母异位词分组
 * @modified By：
 * @version: 1.1
 */
public class question49 {
    /*
     * @Author liumt
     * @Description 按计数分类
     * @Date 23:56 2020/8/29
     * @Param [strs]
     * @return java.util.List<java.util.List<java.lang.String>>
     **/
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length <= 0) return new ArrayList();
        //key存放26个数字,用#隔开,分别代表每个字母出现的次数
        Map<String, List> map = new HashMap<>();
        int[] count = new int[26];
        for(String s: strs){
            //把数组清空
            Arrays.fill(count, 0);
            //计算每个字母出现的次数
            for(Character c: s.toCharArray()) count[c - 'a']++;
            StringBuffer sb = new StringBuffer();
            //获取key
            for(int i = 0; i < 26; i++){
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            //map中不存在就放一个空的list
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            //list中添加字符串
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
