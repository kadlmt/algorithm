package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/9 13:11
 * @description：反转从位置 m 到 n 的链表。请使用一趟扫描完成反转
 * @modified By：
 * @version: 1.1
 */
public class question92 {
    /**
     * @Author liumt
     * @Description g代表m的前置节点,p.next代表需要头插的节点
     * @Date 13:11 2020/10/9
     * @Param [head, m, n]
     * @return linkedList.ListNode
     **/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode g = dummy;
        ListNode p = dummy.next;
        //找到g和p
        for(int i = 0; i < m - 1; i++){
            g = g.next;
            p = p.next;
        }
        //使用头插法,反转链表
        for(int i = 0; i < n - m; i++){
            ListNode remove = p.next;
            p.next = p.next.next;
            remove.next = g.next;
            g.next = remove;
        }
        return dummy.next;
    }
}
