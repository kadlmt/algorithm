package tree;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/29 12:48
 * @description：二叉搜索树中的搜索
 * @modified By：
 * @version: 1.1
 */
public class question700 {
    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }

    public TreeNode dfs(TreeNode root, int val){
        if(root == null) return null;
        if(val < root.val) return dfs(root.left, val);
        if(val > root.val) return dfs(root.right, val);
        return root;
    }
}
