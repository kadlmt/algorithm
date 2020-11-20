package introductionAlgorithm.sort;

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

    public static int[] countSort2(int[] array){
        int max = array[0];
        int min = array[0];
        //统计最大值和最小值
        for(int i = 0; i < array.length; i++){
            if(array[i] > max) max = array[i];
            if(array[i] < min) min = array[i];
        }
        int d = max - min;
        int[] countArray = new int[d + 1];
        //统计元素个数
        for(int i = 0; i < array.length; i++){
            countArray[array[i] - min] += 1;
        }
        //统计数组变形
        for(int i = 1; i < countArray.length; i++){
            countArray[i] += countArray[i - 1];
        }
        int[] sortArray = new int[array.length];
        for(int i = array.length - 1; i >= 0; i--){
            sortArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortArray;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0, 10};
        int[] sortedArray = countSort2(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
