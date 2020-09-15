package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/15 12:11
 * @description：反转链表
 * @modified By：
 * @version: 1.1
 */
public class question206 {
    public ListNode reverseList(ListNode head) {
        ListNode left = null;
        ListNode cur = head;
        while(cur != null){
            //保存下一个节点
            ListNode nextNode = cur.next;
            //开始反转
            cur.next = left;
            //left和cur右移一位
            left = cur;
            cur = nextNode;
        }
        return left;
    }
}
