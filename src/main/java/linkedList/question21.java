package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/19 0:50
 * @description：合并两个有序链表
 * @modified By：
 * @version: 1.1
 */
public class question21 {
    /*
     * @Author liumt
     * @Description prev总是指向小的节点,然后小的节点对应的链表的指针后移
     * 当某一个指针为空,直接把不为空的指针的链表,加到prev上
     * @Date 0:51 2020/8/19
     * @Param [l1, l2]
     * @return linkedList.ListNode
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if(l1 != null) prev.next = l1;
        if(l2 != null) prev.next = l2;
        return head.next;
    }
}
