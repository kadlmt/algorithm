package tree;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/9 0:09
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class question671 {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int min){
        if(root == null) return -1;
        if(root.val > min) return root.val;
        int left = dfs(root.left, min);
        int right = dfs(root.right, min);
        if(left == -1) return right;
        if(right == -1) return left;
        return Math.min(left, right);
    }
}
