package linkedList;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/15 0:08
 * @description：设计链表
 * @modified By：
 * @version: 1.1
 */
public class question707 {
    /*
     * @Author liumt
     * @Description 链表的节点
     * @Date 23:56 2020/8/15
     * @Param
     * @return
     **/
    public class Node{
        public int value;
        public Node prev;
        public Node next;
        public Node(int x){
            this.value = x;
        }
    }

    /*
     * @Author liumt
     * @Description 单向链表,先实现addIndex
     * @Date 23:56 2020/8/15
     * @Param
     * @return
     **/
    class MyLinkedList {
        private int size;
        private Node head;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            this.size = 0;
            this.head = new Node(0);
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index < 0 || index >= size) return -1;
            Node node = head;
            for(int i = 0; i < index + 1; i++){
                node = node.next;
            }
            return node.value;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index > size) return;
            if(index < 0) index = 0;
            size++;
            Node preNode = head;
            for(int i = 0; i < index; i++){
                preNode = preNode.next;
            }
            Node toAdd = new Node(val);
            toAdd.next = preNode.next;
            preNode.next = toAdd;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index < 0 || index >= size)return;
            size--;
            Node preNode = head;
            for(int i = 0; i < index; i++){
                preNode = preNode.next;
            }
            preNode.next = preNode.next.next;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

}
