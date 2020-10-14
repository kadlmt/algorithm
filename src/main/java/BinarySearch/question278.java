package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/14 17:15
 * @description：发现第一个错误版本,由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的
 * @modified By：
 * @version: 1.1
 */
public class question278 {
    /**
     * @Author liumt
     * @Description 二分查找
     * @Date 17:17 2020/10/14
     * @Param [n]
     * @return int
     **/
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left >> 1);
            if(isBadVersion(mid)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid){
        return true;
    }
}
