package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：liumt
 * @date ：Created in 2020/11/2 12:51
 * @description：二叉树的最小深度
 * @modified By：
 * @version: 1.1
 */
public class question111 {
    /**
     * @Author liumt
     * @Description DFS
     * @Date 12:51 2020/11/2
     * @Param [root]
     * @return int
     **/
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        //左子树深度
        int left = minDepth(root.left);
        //右子树深度
        int right = minDepth(root.right);
        return (left == 0 || right == 0)?left + right + 1: Math.min(left, right) + 1;
    }

    /**
     * @Author liumt
     * @Description BFS
     * @Date 13:19 2020/11/2
     * @Param [root]
     * @return int
     **/
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) return ++depth;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return 0;
    }
}
