package linkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/8 15:45
 * @description：验证回文链表
 * @modified By：
 * @version: 1.1
 */
public class question234 {
    /**
     * @Author liumt
     * @Description 借助栈,数组等等都可以
     * @Date 15:46 2020/10/8
     * @Param [head]
     * @return boolean
     **/
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> dq = new LinkedList<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(head != null){
            dq.push(head.val);
            head = head.next;
        }
        head = dummy.next;
        while(head != null){
            if(head.val != dq.pop()) return false;
            head = head.next;
        }
        return true;
    }

    /**
     * @Author liumt
     * @Description 快慢指针找到中间节点;反转后半链表,返回尾结点
     * 迭代两个链表
     * @Date 17:17 2020/10/8
     * @Param [head]
     * @return boolean
     **/
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) return true;
        //获取中间节点
        ListNode midNode = getMidNode(head);
        //反转后半链表,返回尾结点
        ListNode lastNode = reverseList(midNode);
        while(lastNode != null){
            if(head.val != lastNode.val) return false;
            head = head.next;
            lastNode = lastNode.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode mid){
        ListNode prev = null;
        ListNode cur = mid;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode getMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        //获取链表的中间节点
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
