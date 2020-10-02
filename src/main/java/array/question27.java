package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/2 9:10
 * @description：移出元素
 * @modified By：
 * @version: 1.1
 */
public class question27 {
    /**
     * @Author liumt
     * @Description 双指针,吧非val的移到左边,val放到右边.
     * @Date 9:10 2020/10/2
     * @Param [nums, val]
     * @return int
     **/
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        return j;
    }
}
