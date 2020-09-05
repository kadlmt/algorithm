package tree;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/5 23:08
 * @description：单值二叉树
 * @modified By：
 * @version: 1.1
 */
public class question965 {
    /*
     * @Author liumt
     * @Description 深度优先搜索
     * @Date 23:18 2020/9/5
     * @Param [root]
     * @return boolean
     **/
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        if((root.left != null && root.left.val != root.val)
                || (root.right != null && root.right.val != root.val)
                ) return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
