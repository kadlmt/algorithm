package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/9 21:47
 * @description：给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字
 * @modified By：
 * @version: 1.1
 */
public class question82 {
    /**
     * @Author liumt
     * @Description 三指针,每轮结束,三个指针都要相邻.
     * @Date 21:48 2020/10/9
     * @Param [head]
     * @return linkedList.ListNode
     **/
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //前置指针
        ListNode prev = dummy;
        //比较指针1
        ListNode cur1 = head;
        //比较指针2
        ListNode cur2 = head.next;
        //是否存在相同的节点
        boolean flag = false;
        while(cur2 != null){
            //比较节点不同,三个指针同时后移
            if(cur2 != null && cur1.val != cur2.val){
                prev = cur1;
                cur1 = cur2;
                cur2 = cur2.next;
            }
            //两个指针相同,两个指针同时后移,并把flag置为true
            while(cur2 != null && cur2.val == cur1.val){
                flag = true;
                cur1 = cur2;
                cur2 = cur2.next;
            }
            //存在相同节点
            if(flag){
                //prev直接指向cur2;此时cur2一定和cur1不同,相当于把重复的节点全部删除了
                prev.next = cur2;
                if(cur2 != null){
                    //cur1指向cur2,cur2向后移动
                    cur1 = cur2;
                    cur2 = cur2.next;
                    flag = false;
                }
            }
        }
        return dummy.next;
    }
}
