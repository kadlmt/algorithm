package string;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/6 0:00
 * @description：给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串
 * 出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 使用双指针的方法
 * 时间复杂度:O((N−L)L)
 * 空间复杂度:O(1)
 * @modified By：
 * @version: 1.1
 */
public class question28 {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // 如果字符一直不等,pn就往后移位
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            // 每次重新匹配,pl都从0开始
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // 匹配成功返回
            if (currLen == L) return pn - L;

            // 匹配不成功,pn就回溯
            pn = pn - currLen + 1;
        }
        return -1;
    }

}
