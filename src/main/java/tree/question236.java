package tree;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/28 21:55
 * @description：二叉树的最近公共祖先
 * @modified By：
 * @version: 1.1
 */
public class question236 {
    private TreeNode result;
    /**
     * @Author liumt
     * @Description 后序遍历的思想
     * 1.左右子树都包含目标节点
     * 2.root包含一个目标节点,左子树或右子树包含一个节点
     * @Date 21:55 2020/9/28
     * @Param [root, p, q]
     * @return tree.TreeNode
     **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p , q);
        return result;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if((left && right) ||
                ((root.val == p.val || root.val == q.val) && (left || right))){
            result = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }
}
