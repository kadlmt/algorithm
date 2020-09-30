package xiaohui;

import java.util.Random;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/29 15:41
 * @description：java实现跳表
 * @modified By：
 * @version: 1.1
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;
    private Random r = new Random();
    private Node head = new Node(MAX_LEVEL);

    private Node find(int value){
        Node p = head;
        // 从最大层开始查找，找到前一节点，通过--i，移动到下层再开始查找
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 找到前一节点
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    private void insert(int value){
        int level = head.forwards[0] == null ? 1 : randomLevel();
        // 每次只增加一层，如果条件满足
        if (level > levelCount) {
            level = ++levelCount;
        }
        Node newNode = new Node(level);
        newNode.data = value;
        Node p = head;
        // 从最大层开始查找，找到前一节点，通过--i，移动到下层再开始查找
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 找到前一节点
                p = p.forwards[i];
            }
            // levelCount 会 > level，所以加上判断
            if (level > i) {
                if (p.forwards[i] == null) {
                    p.forwards[i] = newNode;
                } else {
                    Node next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }

        }
    }

    private void delete(int value){
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    /**
     * @Author liumt
     * @Description 随机level次
     * @Date 16:25 2020/9/29
     * @Param []
     * @return int
     **/
    public int randomLevel(){
        int level = 1;
        for(int i = 1; i < MAX_LEVEL; i++){
            if((r.nextInt() & 1) == 1){
                level++;
            }
        }
        return level;
    }

    /**
     * @Author liumt
     * @Description Node节点
     * @Date 16:26 2020/9/29
     * @Param
     * @return
     **/
    public class Node{
        private int data = -1;
        //表示当前节点位置下一个节点所有层的数据
        //forwards[3]表示当前节点在第三层的下一个节点。
        private Node[] forwards;
        public Node(int level) {
            forwards = new Node[level];
        }
    }
}
