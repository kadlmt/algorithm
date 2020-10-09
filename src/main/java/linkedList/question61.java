package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/9 20:38
 * @description：给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
 * @modified By：
 * @version: 1.1
 */
public class question61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        //链表产固定
        int size = 0;
        //假头
        ListNode dummy = new ListNode(-1);
        //旋转后的尾结点,也是需要断开的地方
        ListNode prev = dummy;
        //旋转后的头结点
        ListNode cur = dummy.next;
        dummy.next = head;
        //获取链表长度,并吧链表首尾相连
        while(head != null){
            size++;
            if(head.next == null){
                head.next = dummy.next;
                break;
            }
            head = head.next;
        }
        int n =  size - (k % size);
        for(int i = 0 ; i < n; i++){
            prev = prev.next;
        }
        cur = prev.next;
        //尾部断开
        prev.next = null;
        return cur;
    }
}
