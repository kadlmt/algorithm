package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/12 22:13
 * @description：小于x的在左边,大于等于x的在右边
 * @modified By：
 * @version: 1.1
 */
public class question86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLeft = new ListNode(-1);
        ListNode dummyRight = new ListNode(-1);
        ListNode left = dummyLeft;
        ListNode right = dummyRight;
        while(head != null){
            if(head.val < x){
                left.next = head;
                left = left.next;
            } else{
                right.next = head;
                right = right.next;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        left.next = dummyRight.next;
        return dummyLeft.next;
    }
}
