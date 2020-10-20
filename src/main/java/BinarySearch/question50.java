package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/19 12:47
 * @description：x的n次幂
 * @modified By：
 * @version: 1.1
 */
public class question50 {
    /**
     * @Author liumt
     * @Description 快速幂+递归
     * @Date 12:47 2020/10/19
     * @Param [x, n]
     * @return double
     **/
    public double myPow(double x, int n) {
        double result = quickMul(x, n);
        return n > 0?result: 1.0 / result;
    }

    public double quickMul(double x, int n){
        if(n == 0) return 1.0;
        double a = quickMul(x, n / 2);
        return n % 2 == 0?a * a: a * a * x;
    }
}
