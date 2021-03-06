package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/25 0:23
 * @description：x的平方根
 * @modified By：
 * @version: 1.1
 */
public class question69 {
    /*
     * @Author liumt
     * @Description 二分法
     * @Date 0:24 2020/8/25
     * @Param [x]
     * @return int
     **/
    int mySqrt(int x) {
        int l = 1;
        int r = x;
        if (x == 0) return 0;
        if (x == 1) return 1;
        while(l<r) {
            int mid = (l+r)/2;
            if (x/mid == mid) {
                return mid;
            } else if (x/mid > mid) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l-1;
    }

    int mySqrt2(int x){
        int left = 0;
        int right = x;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left >> 1);
            if(mid * mid == x) return mid;
            if((long)mid * mid < x){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
