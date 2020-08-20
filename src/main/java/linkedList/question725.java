package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/20 23:30
 * @description：分割链表
 * 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * @modified By：
 * @version: 1.1
 */
public class question725 {
    /*
     * @Author liumt
     * @Description 
     * @Date 23:31 2020/8/20
     * @Param [root, k]
     * @return linkedList.ListNode[]
     **/
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode cur = root;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        //多出来的值,要均匀的分配在前面的节点
        int mod = length % k;
        //每个链表的长度
        int size = length / k;
        cur = root;
        ListNode[] result = new ListNode[k];
        for(int i = 0; cur != null && i < k; i++){
            result[i] = cur;
            int currentSize = size;
            if(mod > 0){
                currentSize++;
                mod--;
            }
            for(int j = 0; j < currentSize - 1; j++){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return result;
    }
}
