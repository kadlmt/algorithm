package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/30 16:47
 * @description：两数之和,有序的数组
 * @modified By：
 * @version: 1.1
 */
public class question167 {
    /**
     * @Author liumt
     * @Description 二分查找
     * @Date 16:47 2020/9/30
     * @Param [numbers, target]
     * @return int[]
     **/
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            int temp = target - numbers[i];
            int low = i + 1;
            int high = numbers.length - 1;
            while(low <= high){
                int mid = low + ((high - low) >> 1);
                if(numbers[mid] == temp){
                    return new int[]{i + 1, mid + 1};
                }
                if(numbers[mid] > temp){
                    high = mid - 1;
                }
                if(numbers[mid] < temp){
                    low = mid + 1;
                }
            }
        }
        return null;
    }

    /**
     * @Author liumt
     * @Description 双指针,和大于target,右指针左移;和小于target,左指针右移
     * @Date 16:57 2020/9/30
     * @Param [numbers, target]
     * @return int[]
     **/
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left + 1, right + 1};
            }
            if(sum > target){
                right--;
            }
            if(sum < target){
                left++;
            }
        }
        return null;
    }
}
