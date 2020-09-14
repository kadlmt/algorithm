package xiaohui;

import linkedList.question707;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/14 10:13
 * @description：判断链表是否有环,求环的长度
 * @modified By：
 * @version: 1.1
 */
public class IsCycle {
    public static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    /**
     * @Author liumt
     * @Description 判断链表是否有环,基于快慢指针,如果有环,一定会相遇
     * @Date 10:58 2020/9/14
     * @Param [node]
     * @return void
     **/
    public static boolean isCycle(Node node){
        Node lower = node;
        Node fast = node;
        while(fast != null && fast.next != null){
            lower = lower.next;
            fast = fast.next.next;
            if(fast == lower){
                return true;
            }
        }
        return false;
    }

    /**
     * @Author liumt
     * @Description 求环的长度,快慢指针第一次相遇后,快指针不动,慢指针继续移动
     * 下一次相遇,慢指针走的步数就是环的商都
     * @Date 11:18 2020/9/14
     * @Param [node]
     * @return int
     **/
    public static int cycleLength(Node node){
        Node fast = node;
        Node lower = node;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            lower = lower.next;
            if(fast == lower){
                int count = 1;
                lower = lower.next;
                while(fast != lower){
                    lower = lower.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println(isCycle(node1));
        System.out.println(cycleLength(node1));
    }
}
