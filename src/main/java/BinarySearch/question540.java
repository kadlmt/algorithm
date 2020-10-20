package BinarySearch;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/20 12:35
 * @description：有序数组中的单一元素.元素都是成对的,只有一个单一元素,找出来
 * @modified By：
 * @version: 1.1
 */
public class question540 {
    /**
     * @Author liumt
     * @Description 二分
     * @Date 12:35 2020/10/20
     * @Param [nums]
     * @return int
     **/
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left >> 1);
            boolean isEven = (right - mid & 1) == 0;
            if(isEven){//切分开来是偶数
                if(nums[mid + 1] == nums[mid]){//和mid相等的在右边,单一数组在右边
                    left = mid + 2;
                }else if(nums[mid - 1] == nums[mid]){//和mid相等的在左边,单一数组在左边
                    right = mid - 2;
                }else{//单一元素
                    return nums[mid];
                }
            } else {//切分开来是奇数
                if(nums[mid + 1] == nums[mid]){//和mid相等的在右边,单一数组在左边边
                    right = mid - 1;
                }else if(nums[mid - 1] == nums[mid]){//和mid相等的在左边,单一数组在右边
                    left = mid + 1;
                }else{//单一元素
                    return nums[mid];
                }
            }
        }
        return nums[left];
    }
}
