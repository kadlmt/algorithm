package xiaohui;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/14 12:39
 * @description：位图
 * @modified By：
 * @version: 1.1
 */
public class MyBitMap {
    private long[] words;

    /**
     * @Author liumt
     * @Description bitMap位数大小
     * @Date 12:41 2020/9/14
     * @Param
     * @return
     **/
    private int size;

    public MyBitMap(int size){
        this.size = size;
        this.words = new long[getWordIndex(size)];
    }

    public int getWordIndex(int size){
        return (size - 1) >>> 6 + 1;
    }

    /**
     * @Author liumt
     * @Description 获取某一个bit的状态
     * @Date 13:00 2020/9/14
     * @Param [bitIndex]
     * @return boolean
     **/
    public boolean getBit(int bitIndex){
        if(bitIndex < 0 || bitIndex > size - 1){
            throw new IndexOutOfBoundsException("超出bitMap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    /**
     * @Author liumt
     * @Description 修改bit位的状态
     * @Date 13:05 2020/9/14
     * @Param [bitIndex]
     * @return void
     **/
    public void setBit(int bitIndex){
        if(bitIndex < 0 || bitIndex > size - 1){
            throw new IndexOutOfBoundsException("超出bitMap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= 1L << bitIndex;
    }
}
