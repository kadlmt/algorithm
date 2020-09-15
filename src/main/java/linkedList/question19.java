package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/15 13:07
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class question19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个假头
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lower = dummy;
        ListNode fast = dummy;
        //快指针移动n+1步
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        //快慢指针同时移动一步,知道快指针为空,就到了尾结点
        while(fast != null){
            lower = lower.next;
            fast = fast.next;
        }
        //修改慢指针的指向,来删除节点.
        lower.next = lower.next.next;
        return dummy.next;
    }
}
