package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/24 23:58
 * @description：山脉数组的峰顶索引
 * @modified By：
 * @version: 1.1
 */
public class question852 {
    /*
     * @Author liumt
     * @Description 二分法公式
     * @Date 23:59 2020/8/24
     * @Param [A]
     * @return int
     **/
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(A[mid] > A[mid + 1]){
                right = mid - 1;
            }
            if(A[mid] < A[mid + 1]){
                left = mid + 1;
            }
        }
        return left;
    }
}
