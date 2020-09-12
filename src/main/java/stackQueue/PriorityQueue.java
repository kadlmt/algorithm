package stackQueue;

import java.util.Arrays;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/11 17:38
 * @description：优先队列,使用最大堆来实现
 * @modified By：
 * @version: 1.1
 */
public class PriorityQueue {
    private int[] array;
    private int size;
    public PriorityQueue(){
        //初始化数组大小32
        array = new int[32];
    }

    /*
     * @Author liumt
     * @Description 入队操作
     * @Date 10:58 2020/9/12
     * @Param [key]
     * @return int
     **/
    public void offset(int key){
        if(size >= array.length){
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /*
     * @Author liumt
     * @Description 出队操作
     * @Date 10:59 2020/9/12
     * @Param []
     * @return int
     **/
    public int poll() throws Exception {
        if(size <= 0){
            throw new Exception("queue is empty");
        }
        //获取堆顶元素
        int head = array[0];
        array[0] = array[--size];
        downAjust();
        return head;
    }

    /*
     * @Author liumt
     * @Description 上浮操作
     * @Date 10:59 2020/9/12
     * @Param [array]
     * @return void
     **/
    public void upAdjust(){
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && array[childIndex] > array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /*
     * @Author liumt
     * @Description 下沉操作
     * @Date 11:02 2020/9/12
     * @Param []
     * @return void
     **/
    public void downAjust(){
        int parentIndex = 0;
        int childIndex = 2 * parentIndex + 1;
        int temp = array[parentIndex];
        while (parentIndex < size - 1){
            //如果存在右孩子,且右孩子比左孩子大,则和右孩子交换
            if(childIndex + 1 < size && array[childIndex] < array[childIndex + 1]){
                childIndex++;
            }
            if(temp > array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /*
     * @Author liumt
     * @Description 扩容
     * @Date 11:04 2020/9/12
     * @Param []
     * @return void
     **/
    public void resize(){
        this.array = Arrays.copyOf(array, size >> 2);
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue() ;
        priorityQueue.offset(3);
        priorityQueue.offset(5);
        priorityQueue.offset(10);
        priorityQueue.offset(2);
        priorityQueue.offset(7);
        System.out.println(" 出 队 元 素：" + priorityQueue.poll());
        System.out.println(" 出 队 元 素：" + priorityQueue.poll());
    }
}
