package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/11 19:00
 * @description：排序链表
 * @modified By：
 * @version: 1.1
 */
public class question148 {
    /**
     * @Author liumt
     * @Description 归并排序链表
     * @Date 19:01 2020/10/11
     * @Param [head]
     * @return linkedList.ListNode
     **/
    public ListNode sortList(ListNode head) {
        //递归终止条件,说明只有一个节点了
        if(head == null || head.next == null) return head;
        //找到链表中点
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        //断链
        slow.next = null;
        //递归切割后的链表
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        //合并链表
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        dummy.next = left;
        ListNode prev = dummy;
        ListNode cur1 = left;
        ListNode cur2 = right;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur1 = cur1.next;
                prev = prev.next;
            } else{
                ListNode next = cur2.next;
                cur2.next = cur1;
                prev.next = cur2;
                prev = prev.next;
                cur2 = next;
            }
        }
        if(cur2 != null) prev.next = cur2;
        return dummy.next;
    }
}
