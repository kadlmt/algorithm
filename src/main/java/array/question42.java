package array;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/1 17:29
 * @description：接雨水.
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @modified By：
 * @version: 1.1
 */
public class question42 {
    /**
     * @Author liumt
     * @Description 暴力解法
     * 对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
     * @Date 17:31 2020/10/1
     * @Param [height]
     * @return int
     **/
    public int trap(int[] height) {
        int result = 0;
        for(int i = 0; i < height.length; i++){
            int max_left = 0;
            int max_right = 0;
            for(int j = i; j >= 0; j--){
                max_left = Math.max(height[j], max_left);
            }
            for(int j = i; j < height.length; j++){
                max_right = Math.max(height[j], max_right);
            }
            result += Math.min(max_left, max_right) - height[i];
        }
        return result;
    }

    /**
     * @Author liumt
     * @Description 动态规划;
     * maxLeft[i]表示i节点,左边的最大值.
     * maxLeft[i] = Math.max(height[i], maxLeft[i - 1])
     * maxRight[i]表示i节点,右边的最大值
     * maxRight[i] = Math.max(height[i], maxRight[i + 1])
     * @Date 7:47 2020/10/2
     * @Param [height]
     * @return int
     **/
    public int trap2(int[] height) {
        if(height == null || height.length <= 0) return 0;
        int result = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = height[0];
        maxRight[height.length - 1] = height[height.length - 1];
        for(int i = 1; i <  height.length; i++){
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        for(int i = height.length - 2; i >= 0; i--){
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        for(int i = 0; i < height.length; i++){
            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return result;
    }

    /**
     * @Author liumt
     * @Description 双指针解法
     * 由于i的可接水量,等于左右两边的较小值-height[i]得知
     * 1.如果maxLeft < maxRight ,则右边的高度,可以直接忽略
     * 2.如果maxLeft >= maxRight, 则左边的高度可以直接忽略
     * @Date 8:17 2020/10/2
     * @Param [height]
     * @return int
     **/
    public int trap3(int[] height) {
        if(height == null || height.length <= 0) return 0;
        int result = 0;
        int length = height.length;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = length - 1;
        while(left <= right){
            if(maxLeft < maxRight){
                result += Math.max(0, maxLeft - height[left]);
                maxLeft = Math.max(height[left], maxLeft);
                left++;
            } else{
                result += Math.max(0, maxRight - height[right]);
                maxRight = Math.max(height[right], maxRight);
                right--;
            }
        }
        return result;
    }
}
