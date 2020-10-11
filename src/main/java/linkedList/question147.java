package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/11 10:58
 * @description：链表的插入排序
 * @modified By：
 * @version: 1.1
 */
public class question147 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if(prev.val <= cur.val){//有序,指针后移
                prev = cur;
                cur = cur.next;
            } else{
                //从头结点开始比较,要插入的位置
                ListNode p = dummy;
                while(p.next.val <= cur.val && p.next != cur){
                    p = p.next;
                }
                prev.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = prev.next;
            }
        }
        return dummy.next;
    }
}
