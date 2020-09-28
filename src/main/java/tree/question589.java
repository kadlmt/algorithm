package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/28 12:22
 * @description：N叉树的前序遍历
 * @modified By：
 * @version: 1.1
 */
public class question589 {
    class Node {
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

    /**
     * @Author liumt
     * @Description 前序遍历
     * @Date 12:24 2020/9/28
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    public void dfs(Node root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        for(int i = 0; i < root.children.size(); i++){
            dfs(root.children.get(i), list);
        }
    }
}
