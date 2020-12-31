package introductionAlgorithm.dataStructure;

/**
 * @author liumt
 * @date Created in 2020/12/29 12:51
 * 链表实现栈
 */
public class MyStackList {
    private ListNode dummy;

    public MyStackList() {
        this.dummy = new ListNode(-1);
    }

    /**
     * 出栈
     */
    public int pop() {
        ListNode deleteNode = dummy.next;
        if (deleteNode != null) {
            ListNode prev = deleteNode.prev;
            ListNode next = deleteNode.next;
            prev.next = next;
            if (next != null)
                next.prev = prev;
            return deleteNode.val;
        }
        return -1;
    }

    /**
     * 入栈
     */
    public void push(int x) {
        ListNode nextNode = dummy.next;
        ListNode newNode = new ListNode(x);
        dummy.next = newNode;
        newNode.next =  nextNode;
        if (nextNode != null)
            nextNode.prev = newNode;
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
        MyStackList stack = new MyStackList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
