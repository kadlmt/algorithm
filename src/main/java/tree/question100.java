package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/4 23:28
 * @description：相同的树
 * @modified By：
 * @version: 1.1
 */
public class question100 {
    /*
     * @Author liumt
     * @Description 深度优先搜索
     * @Date 23:29 2020/9/4
     * @Param [p, q]
     * @return boolean
     **/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null || q == null)
            return false;
        else if(p.val != q.val)
            return false;
        else
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /*
     * @Author liumt
     * @Description 广度优先搜索
     * @Date 23:49 2020/9/4
     * @Param [p, q]
     * @return boolean
     **/
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null || q == null)
            return false;
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(p);
        queue2.offer(q);
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if(node1.val != node2.val)
                return false;
            TreeNode left1 = node1.left;
            TreeNode left2 = node2.left;
            TreeNode right1 = node1.right;
            TreeNode right2 = node2.right;
            if(left1 == null ^ left2 == null)
                return false;
            if(right1 == null ^ right2 == null)
                return false;
            if(left1 != null)
                queue1.offer(left1);
            if(right1 != null)
                queue1.offer(right1);
            if(left2 != null)
                queue2.offer(left2);
            if(right2 != null)
                queue2.offer(right2);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
