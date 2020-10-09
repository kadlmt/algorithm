package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/16 23:22
 * @description：两数相加,表头低位
 * @modified By：
 * @version: 1.1
 */
public class question2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /*
     * @Author liumt
     * @Description 定义一个虚拟头结点,定义一个进位标志
     * sum/10标识是否进位,sum%10标识当前节点的值
     * @Date 23:23 2020/8/16
     * @Param [l1, l2]
     * @return linkedList.question2.ListNode
     **/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        int carry = 0;
        ListNode cur = head;
        while(l1 != null || l2 != null){
            int x = l1 == null?0: l1.val;
            int y = l2 == null?0: l2.val;
            int sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            if(l1 == null && l2 == null && carry > 0){
                cur.next =new ListNode(carry);
            }
        }
        return head.next;
    }
}
