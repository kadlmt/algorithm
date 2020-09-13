package sort;

import java.util.Arrays;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/13 20:06
 * @description：计数排序
 * @modified By：
 * @version: 1.1
 */
public class CountSort {
    public static int[] countSort(int[] array){
        //获取最大值
        int maxValue = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] > maxValue){
                maxValue = array[i];
            }
        }
        //记录每个数字出现的次数
        int[] nums = new int[maxValue + 1];
        for(int i = 0; i < array.length; i++){
            nums[array[i]] += 1;
        }
        int index = 0;
        int[] sortArray = new int[array.length];
        //遍历nums
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i]; j ++){
                sortArray[index++] = i;
            }
        }
        return sortArray;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0, 10};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
