package xiaohui;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/17 23:41
 * @description：冒泡排序
 * @modified By：
 * @version: 1.1
 */
public class BubbleSort {
    public static int[] bubblingSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 4, 7, 1, 3, 2, 6};
        bubblingSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
