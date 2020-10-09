package linkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/8 14:31
 * @description：两数相加2,表头高位
 * @modified By：
 * @version: 1.1
 */
public class question455 {
    /**
     * @Author liumt
     * @Description 借助栈
     * @Date 14:32 2020/10/8
     * @Param [l1, l2]
     * @return linkedList.ListNode
     **/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> d1 = new LinkedList<>();
        Deque<Integer> d2 = new LinkedList<>();
        ListNode head = new ListNode(-1);
        while(l1 != null){
            d1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            d2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while(!d1.isEmpty() || !d2.isEmpty()){
            int x = d1.isEmpty()?0: d1.pop();
            int y = d2.isEmpty()?0: d2.pop();
            int sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            //头插
            if(head.next != null){
                ListNode node = new ListNode(sum);
                node.next = head.next;
                head.next = node;
            } else{
                head.next = new ListNode(sum);
            }
            if(d1.isEmpty() && d2.isEmpty() && carry > 0){
                ListNode node = new ListNode(carry);
                node.next = head.next;
                head.next = node;
            }
        }
        return head.next;
    }
}
