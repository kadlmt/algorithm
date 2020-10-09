package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/15 12:36
 * @description：判断链表是否有环
 * @modified By：
 * @version: 1.1
 */
public class question141 {
    /**
     * @Author liumt
     * @Description 快慢指针,如果有环,必定会相遇.如果fast为null,则没有环
     * @Date 12:36 2020/9/15
     * @Param [head]
     * @return boolean
     **/
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
