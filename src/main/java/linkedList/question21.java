package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/19 0:50
 * @description：合并两个有序链表
 * @modified By：
 * @version: 1.1
 */
public class question21 {
    /**
     * @Author liumt
     * @Description prev总是指向小的节点,然后小的节点对应的链表的指针后移
     * 当某一个指针为空,直接把不为空的指针的链表,加到prev上
     * @Date 0:51 2020/8/19
     * @Param [l1, l2]
     * @return linkedList.ListNode
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        ListNode prev = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null){
            //如果cur1小于cur2,指针的后移
            if(cur1.val <= cur2.val){
                cur1 = cur1.next;
                prev = prev.next;
            } else{//反之,cur2插入prev后面,cur1前面
                ListNode temp = cur2.next;
                cur2.next = cur1;
                prev.next = cur2;
                prev = prev.next;
                cur2 = temp;
            }
        }
        if(cur2 != null) prev.next = cur2;
        return dummy.next;
    }
}
