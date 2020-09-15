package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/15 13:15
 * @description：找到链表的中间节点.
 * @modified By：
 * @version: 1.1
 */
public class question876 {
    public ListNode middleNode(ListNode head) {
        ListNode lower = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            lower = lower.next;
        }
        return lower;
    }
}
