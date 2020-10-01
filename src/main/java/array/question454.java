package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/1 15:07
 * @description：四个数组,4数之和为0
 * @modified By：
 * @version: 1.1
 */
public class question454 {
    /**
     * @Author liumt
     * @Description 两两相加，然后存在字典里面查找
     * @Date 15:08 2020/10/1
     * @Param [A, B, C, D]
     * @return int
     **/
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int result = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int sumAB = A[i] + B[j];
                if(hashMap.containsKey(sumAB)){
                    hashMap.put(sumAB, hashMap.get(sumAB) + 1);
                } else{
                    hashMap.put(sumAB, 1);
                }
            }
        }
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int sumCD = -(C[i] + D[j]);
                if(hashMap.containsKey(sumCD)){
                    result += hashMap.get(sumCD);
                }
            }
        }
        return result;
    }
}
