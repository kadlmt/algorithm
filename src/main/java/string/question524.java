package string;

import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/9 23:36
 * @description：给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
 * 该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，
 * 返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * @modified By：
 * @version: 1.1
 */
public class question524 {
    /**
     * @Author liumt
     * @Description 使用双指针的解法,不是最优解
     * @Date 23:37 2020/8/9
     * @Param [s, d]
     * @return java.lang.String
     **/
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for(String ds: d){
            int l1 = 0;
            int l2 = 0;
            while(l1 < s.length() && l2 < ds.length()){
                int c1 = s.charAt(l1);
                int c2 = ds.charAt(l2);
                if(c1 == c2){
                    l1++;
                    l2++;
                }else{
                    l1++;
                }
            }
            if(l2 == ds.length()){
                if("".equals(result)){
                    result = ds;
                }
                else if(result.length() == ds.length()){
                    result = result.compareTo(ds) > 0?ds: result;
                } else{
                    result = result.length() > ds.length()?result: ds;
                }
            }
        }
        return result;
    }
}
