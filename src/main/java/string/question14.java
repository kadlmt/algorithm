package string;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/22 13:23
 * @description：最长公共前缀
 * @modified By：
 * @version: 1.1
 */
public class question14 {
    /**
     * @Author liumt
     * @Description 纵向扫描
     * @Date 13:24 2020/9/22
     * @Param [strs]
     * @return java.lang.String
     **/
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length <= 0) return "";
        int length = strs[0].length();
        for(int i = 0; i < length; i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
