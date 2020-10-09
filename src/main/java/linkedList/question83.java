package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/16 23:56
 * @description：给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @modified By：
 * @version: 1.1
 */
public class question83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if(prev.val == cur.val){
                prev.next = cur.next;
                cur = cur.next;
            } else{
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
