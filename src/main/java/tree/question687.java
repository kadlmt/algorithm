package tree;

/**
 * @author liumt
 * @date Created in 2020/11/9 13:07
 * 最长同值路径
 */
public class question687 {
    private int maxPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int allowLeft = 0;
        int allowRight = 0;
        //如果根节点值和左孩子相等,则根节点左最长直径 = 左孩子的最长直径 + 1
        if(root.left != null && root.val == root.left.val) allowLeft += left + 1;
        //如果根节点值和右孩子相等,则根节点右最长直径 = 右孩子的最长直径 + 1
        if(root.right != null && root.val == root.right.val) allowRight += right + 1;
        //最长同值路径 = 左最长直径 + 右最长直径
        maxPath = Math.max(maxPath, allowLeft + allowRight);
        //返回最长直径
        return Math.max(allowLeft, allowRight);
    }
}
