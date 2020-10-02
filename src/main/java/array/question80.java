package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/2 20:27
 * @description：给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度
 * @modified By：
 * @version: 1.1
 */
public class question80 {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int length = nums.length;
        for(int i = 1; i < length; i++){
            if(nums[i] == nums[i - 1]){
                count++;
                //重复元素出现三次,开始删除该节点,后面的节点向前移动
                //数组长度-1
                //i向前回溯一位
                if(count > 2){
                    for(int j = i; j < length - 1; j++){
                        nums[j] = nums[j + 1];
                    }
                    length--;
                    i--;
                }
            } else{
                count = 1;
            }
        }
        return length;
    }
}
