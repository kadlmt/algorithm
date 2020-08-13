package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/13 23:31
 * @description：给定一个按递增顺序排序的整数数组A，
 * 返回每个数字的平方组成的新数组，要求也按递增顺序排序。
 * @modified By：
 * @version: 1.1
 */
public class question977 {
    /*
     * @Author liumt
     * @Description 双指针,先找到正数和负数的分界点.负数指针向前走,正数指针向后走
     * 比较两个指针平方的大小
     * @Date 23:32 2020/8/13
     * @Param [A]
     * @return int[]
     **/
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int j = 0;
        while(j < N && A[j] < 0)
            j++;
        int i = j - 1;
        int[] result = new int[N];
        int t = 0;
        while(i >= 0 && j < N){
            if(A[i] * A[i] > A[j] * A[j]){
                result[t++] = A[j] * A[j];
                j++;
            }else{
                result[t++] = A[i] * A[i];
                i--;
            }
        }
        while(i >= 0){
            result[t++] = A[i] * A[i];
            i--;
        }
        while(j < N){
            result[t++] = A[j] * A[j];
            j++;
        }
        return result;
    }
}
