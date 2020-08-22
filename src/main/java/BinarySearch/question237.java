package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/22 23:49
 * @description：给定一个包含 n + 1 个整数的数组 nums，
 * 其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 * @modified By：
 * @version: 1.1
 */
public class question237 {
    /*
     * @Author liumt
     * @Description 二分法
     * 遍历数组,得到所有大于mid的个数cnt
     * 如果cnt < mid 重复数在右边
     * 反之重复数在左边
     * @Date 0:09 2020/8/23
     * @Param [nums]
     * @return int
     **/
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = length - 1;
        while(left < right){
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for(int i = 0; i < length; i++){
                if(nums[i] <= mid)
                    cnt++;
            }
            if(cnt <= mid){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return left;
    }

    /*
     * @Author liumt
     * @Description 快慢指针,了解龟兔赛跑算法
     * @Date 0:12 2020/8/23
     * @Param [nums]
     * @return int
     **/
    public int findDuplicate2(int[] nums) {

        return 0;
    }
}
