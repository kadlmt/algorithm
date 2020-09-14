package greedy;

import java.util.Arrays;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/14 20:14
 * @description：分发饼干,g代表胃口,s代表饼干大小.s>=g才能喂饱,求喂饱的最大个数
 * @modified By：
 * @version: 1.1
 */
public class question455 {
    /**
     * @Author liumt
     * @Description 贪心算法,我们只关注胃口最小的孩子,如果饼干不够大,则饼干右移
     * 如果饼干够大,则sum++,两个指针都右移
     * @Date 20:15 2020/9/14
     * @Param [g, s]
     * @return int
     **/
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gp = 0;
        int sp = 0;
        int sum = 0;
        while(gp < g.length && sp < s.length){
            if(s[sp] >= g[gp]){
                sum++;
                gp++;
                sp++;
            } else{
                sp++;
            }
        }
        return sum;
    }
}
