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
     * @Description 后序遍历
     * @Date 23:31 2020/8/26
     * @Param [root]
     * @return tree.TreeNode
     **/
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) return root;
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
