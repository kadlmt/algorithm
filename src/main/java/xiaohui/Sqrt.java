package xiaohui;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/20 18:52
 * @description：x的平方根,保留6位小数
 * @modified By：
 * @version: 1.1
 */
public class Sqrt {
    public static double sqrt(double x){
        double high = x;
        double low = 0;
        double mid = low + (high - low) / 2;
        while(high - low > 0.000001){
            if(mid * mid == x){
                return mid;
            }
            if(mid * mid > x){
                high = mid;
            } else {
                low = mid;
            }
            mid = low + (high - low) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(5));
    }
}
