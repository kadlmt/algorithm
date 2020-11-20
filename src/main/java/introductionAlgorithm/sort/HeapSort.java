package introductionAlgorithm.sort;

import java.util.Arrays;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/13 19:08
 * @description：堆排序,空间复杂度O(1),时间复杂度O(nlogn)
 * @modified By：
 * @version: 1.1
 */
public class HeapSort {
    /*
     * @Author liumt
     * @Description 下沉操作
     * @Date 19:20 2020/9/13
     * @Param [array, parentIndex, length]
     * @return void
     **/
    public static void downAjust(int[] array, int parentIndex, int length){
        int head = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while(childIndex < length){
            if(childIndex + 1 < length && array[childIndex + 1] > array[childIndex]){
                childIndex++;
            }
            if(array[parentIndex] > array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        array[parentIndex] = head;
    }

    /*
     * @Author liumt
     * @Description 堆排升序
     * @Date 19:18 2020/9/13
     * @Param []
     * @return void
     **/
    public static void heapSort(int[] array){
        //构建最大堆
        for(int i = (array.length - 2) / 2; i >=0; i--){
            downAjust(array, i, array.length);
        }
        //循环删除堆顶,移到数组尾部
        for(int i = array.length - 1; i >= 0; i--){
            int head = array[0];
            array[0] = array[i];
            array[i] = head;
            downAjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
