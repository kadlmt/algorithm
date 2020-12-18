package xiaohui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/14 7:47
 * @description：桶排序,平均时间复杂度O(n),最坏时间复杂度O(nlogn)
 * @modified By：
 * @version: 1.1
 */
public class BucketSort {
    public static double[] bucketSort(double[] array) {
        //获取最大值,最小值
        double max = array[0];
        double min = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] > max) max = array[i];
            if(array[i] < min) min = array[i];
        }
        double d = max - min;
        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketList.add(new LinkedList<>());
        }
        //遍历数组,把元素放入桶中
        for(int i = 0; i < array.length; i++){
            int num = (int)((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }
        //对每个桶内部进行排序
        for(int i = 0; i < bucketList.size(); i++){
            Collections.sort(bucketList.get(i));
        }
        //遍历每个桶
        double sortArray[] = new double[array.length];
        int index = 0;
        for(LinkedList<Double> list: bucketList){
            for(Double element: list){
                sortArray[index++] = element;
            }
        }
        return sortArray;
    }

    public static void main(String[] args) {
        double[] array = new double[] {4.12,6.421,0.0023,3.0,2.123,8.122,4.12, 10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
