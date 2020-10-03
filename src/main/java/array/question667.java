package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/3 9:18
 * @description：给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
 * ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 * ② 如果存在多种答案，你只需实现并返回其中任意一种.
 * @modified By：
 * @version: 1.1
 */
public class question667 {
    /**
     * @Author liumt
     * @Description k=1,字符串翻转0次,k=2字符串翻转1次,k=n字符串翻转n-1次
     * @Date 9:19 2020/10/3
     * @Param [n, k]
     * @return int[]
     **/
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        for(int i = 0; i < n; i++) result[i] = i + 1;
        if(k == 1) return result;
        for(int i = 1; i < k; i++){
            reverse(result, i, result.length - 1);
        }
        return result;
    }

    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
