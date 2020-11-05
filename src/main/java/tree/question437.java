package tree;

/**
 * @author liumt
 * @date Created in 2020/11/5 12:48
 * 路径总和3,不一定从根节点开始,不一定从叶子节点结束
 */
public class question437 {
    //dfs,当前节点作为根节点的路径数 + 左节点作为根节点的路径数 + 右节点作为根节点的路径数
    public int pathSum(TreeNode root, int sum) {
        if(root == null ) return 0;
        int roots = dfs(root, sum);
        int left = pathSum(root.left, sum);
        int right = pathSum(root.right, sum);
        return roots + left + right;
    }

    public int dfs(TreeNode root, int sum) {
        if(root == null) return 0;
        sum = sum - root.val;
        int result = sum == 0?1: 0;
        return result + dfs(root.left, sum) + dfs(root.right, sum);
    }
}
