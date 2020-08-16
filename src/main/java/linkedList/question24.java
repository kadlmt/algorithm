package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/16 23:44
 * @description：两两交换链表中的值
 * @modified By：
 * @version: 1.1
 */
public class question24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /*
     * @Author liumt
     * @Description 递归交换
     * 返回值：交换完成的子链表
       调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
       终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
     * @Date 23:47 2020/8/16
     * @Param [head]
     * @return linkedList.question24.ListNode
     **/
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
