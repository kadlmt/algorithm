package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/3 19:14
 * @description：数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，
 * 并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同
 * @modified By：
 * @version: 1.1
 */
public class question769 {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            if(max == i) result++;
        }
        return result;
    }
}
