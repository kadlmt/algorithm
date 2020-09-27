package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/27 13:12
 * @description：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
 * @modified By：
 * @version: 1.1
 */
public class question102 {
    /**
     * @Author liumt
     * @Description 广度优先搜索
     * @Date 13:12 2020/9/27
     * @Param [root]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            result.add(list);
        }
        return result;
    }
}
