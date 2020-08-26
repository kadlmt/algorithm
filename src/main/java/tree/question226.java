package tree;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 23:31
 * @description：翻转二叉树
 * @modified By：
 * @version: 1.1
 */
public class question226 {
    /*
     * @Author liumt
     * @Description 递归
     * @Date 23:31 2020/8/26
     * @Param [root]
     * @return tree.TreeNode
     **/
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
