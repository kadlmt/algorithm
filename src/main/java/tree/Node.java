package tree;

import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/28 12:40
 * @description：N叉树
 * @modified By：
 * @version: 1.1
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
