package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/12 21:28
 * @description：合并k个有序链表
 * @modified By：
 * @version: 1.1
 */
public class question23 {
    /**
     * @Author liumt
     * @Description 暴力解法
     * @Date 21:28 2020/10/12
     * @Param [lists]
     * @return linkedList.ListNode
     **/
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length <= 0) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = lists[0];
        for(int i = 1; i < lists.length; i++){
            ListNode prev = dummy;
            ListNode cur1 = dummy.next;
            ListNode cur2  = lists[i];
            while(cur1 != null && cur2 != null){
                if(cur1.val <= cur2.val){
                    prev = cur1;
                    cur1 = cur1.next;
                } else{
                    ListNode next = cur2.next;
                    cur2.next = cur1;
                    prev.next = cur2;
                    prev = prev.next;
                    cur2 = next;
                }
            }
            if(cur2 != null) prev.next = cur2;
        }
        return dummy.next;
    }
}
