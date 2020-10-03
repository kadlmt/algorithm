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

    /**
     * @Author liumt
     * @Description 左右指针,left + right < 0说明left绝对值大,放入结果数组末尾
     * 左指针右移,反之right绝对值大,放入结果数组,右指针左移
     * @Date 19:48 2020/10/3
     * @Param [A]
     * @return int[]
     **/
    public int[] sortedSquares2(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int[] res = new int[A.length];
        for(int i = A.length - 1; i >= 0; i--){
            if(A[left] + A[right] < 0){
                res[i] = A[left] * A[left];
                left++;
            } else{
                res[i] = A[right] * A[right];
                right--;
            }
        }
        return res;
    }
}
