package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/25 23:10
 * @description：二叉树的最大深度
 * @modified By：
 * @version: 1.1
 */
public class question104 {
    /*
     * @Author liumt
     * @Description 递归
     * @Date 23:12 2020/8/25
     * @Param [root]
     * @return int
     **/
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    /*
     * @Author liumt
     * @Description 广度优先搜索
     * @Date 23:28 2020/8/25
     * @Param [root]
     * @return int
     **/
    public int maxDepth2(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while(!queue.isEmpty()){
            //队列大小
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                //如果存在子节点,就往队列丢
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
                size--;
            }
            result++;
        }
        return result;
    }
}
