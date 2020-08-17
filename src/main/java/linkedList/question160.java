package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/17 23:04
 * @description：相交链表
 * @modified By：
 * @version: 1.1
 */
public class question160 {
    /*
     * @Author liumt
     * @Description 双指针方法.当pa==null,pa指向headB;pb==null,指向headA;
     * 当pa==pb,找到相交节点.
     * 当两个节点相交,则他们的末尾节点必定相同;公式:a+b=b+a;
     * @Date 23:05 2020/8/17
     * @Param [headA, headB]
     * @return linkedList.ListNode
     **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != pb){
            pa = pa == null?headB: pa.next;
            pb = pb == null?headA: pb.next;
        }
        return pa;
    }
}
