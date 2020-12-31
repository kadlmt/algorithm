package introductionAlgorithm.dataStructure;

/**
 * @author liumt
 * @date Created in 2020/12/28 12:52
 * 链表
 */
public class MyList {
    private ListNode dummy;

    public MyList() {
        this.dummy = new ListNode(-1);
    }

    /**
     * 根据key寻找节点
     */
    public ListNode listSearch(int x) {
        ListNode head = dummy.next;
        while (head != null) {
            if (x == head.val) return head;
            head = head.next;
        }
        return dummy;
    }

    /**
     * 删除节点
     */
    public void delete(int x) {
        ListNode deleteNode = listSearch(x);
        ListNode prev = deleteNode.prev;
        ListNode next = deleteNode.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * 链表插入
     */
    public void insert(int x) {
       ListNode nextNode = dummy.next;
       ListNode newNode = new ListNode(x);
       dummy.next = newNode;
       newNode.next =  nextNode;
       if (nextNode != null) {
           nextNode.prev = newNode;
       }
       newNode.prev = dummy;
    }

    class ListNode {
        private int val;
        private ListNode next;
        private ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.delete(2);
    }
}
