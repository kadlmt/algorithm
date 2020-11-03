package tree;

/**
 * @author ：liumt
 * @date ：Created in 2020/11/3 12:59
 * @description：二叉树的直径
 * @modified By：
 * @version: 1.1
 */
public class question542 {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
