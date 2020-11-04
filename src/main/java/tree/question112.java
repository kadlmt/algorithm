package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/25 23:42
 * @description：根节点到叶子节点路径总和是否==sum
 * @modified By：
 * @version: 1.1
 */
public class question112 {
    /*
     * @Author liumt
     * @Description DFS解法
     * @Date 23:43 2020/8/25
     * @Param [root, sum]
     * @return boolean
     **/
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
        return left || right;
    }

    /*
     * @Author liumt
     * @Description BFS解法
     * @Date 0:10 2020/8/26
     * @Param [root, sum]
     * @return boolean
     **/
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null)
            return false;
        //存放节点
        Queue<TreeNode> queue = new LinkedList<>();
        //存放节点路径总和
        Queue<Integer> queue2 = new LinkedList<>();
        queue.offer(root);
        queue2.offer(root.val);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int temp = queue2.poll();
            //只有是叶子节点并且路径和==sum,才返回true
            if(node.left == null && node.right == null){
                if(temp == sum){
                    return true;
                }
                continue;
            }
            //左右子树不为空,就把节点和值加入队列
            if(node.left != null){
                queue.offer(node.left);
                queue2.offer(node.left.val + temp);
            }
            if(node.right != null){
                queue.offer(node.right);
                queue2.offer(node.right.val + temp);
            }
        }
        return false;
    }
}
