package xiaohui;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/15 13:18
 * @description：实现lru算法
 * @modified By：
 * @version: 1.1
 */
public class LRUCache {
    private Node head;
    private Node tail;
    private int limit;
    private Map<String , Node> hashMap;
    public LRUCache(int limit){
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    public String get(String key){
        Node node = hashMap.get(key);
        if(node == null){
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value){
        Node node = hashMap.get(key);
        if(node == null){
            //节点不存在
            if(hashMap.size() > limit){
                //达到限制,开始淘汰链表的头部
                deleteNode(head);
                hashMap.remove(head.key);
            } else {
                Node newNode = new Node(key, value);
                addNode(newNode);
                hashMap.put(key, newNode);
            }
        } else {
            //节点存在
        }
    }

    public void remove(String key){

    }

    /**
     * @Author liumt
     * @Description 更新节点
     * @Date 18:20 2020/9/15
     * @Param [node]
     * @return void
     **/
    public void refreshNode(Node node){
        if(tail == node){
            return;
        }
        deleteNode(node);
        addNode(node);
    }

    /**
     * @Author liumt
     * @Description 删除节点
     * @Date 18:21 2020/9/15
     * @Param [node]
     * @return java.lang.String
     **/
    public String deleteNode(Node node){
        if(head == node && tail == node){
            //只有一个节点
            head = null;
            tail = null;
        } else if(tail == node){
            //移出尾结点
            tail = tail.prev;
            tail.next = null;
        } else if(head == node){
            //移出头结点
            head = head.next;
            head.prev = null;
        } else {
            //移出中间节点
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        return node.key;
    }

    /**
     * @Author liumt
     * @Description 尾部添加节点
     * @Date 18:21 2020/9/15
     * @Param [node]
     * @return void
     **/
    public void addNode(Node node){
        if(tail != null){
            tail.next = node;
            node.prev = tail;
            tail = node;
            node.next = null;
        }
        if(head == null){
            head = node;
            tail = node;
        }
    }

    static class Node{
        String key;
        String value;
        Node next;
        Node prev;
        Node(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
}
