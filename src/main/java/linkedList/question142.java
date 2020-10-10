package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/10 13:08
 * @description：求链表环的入口(散列法,快慢指针都可以)
 * @modified By：
 * @version: 1.1
 */
public class question142 {
    /**
     * @Author liumt
     * @Description 快慢指针
     * @Date 13:10 2020/10/10
     * @Param [head]
     * @return linkedList.ListNode
     **/
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        //快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针相交后,该指针开始走
        ListNode slow2 = head;
        //是否有环
        boolean cycle = false;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(!cycle) return null;
        //两个慢指针相遇,就是交点
        while(slow != slow2){
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;
    }
}
