package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liumt
 * @date Created in 2020/11/10 12:50
 * 返回所有从根节点到叶子节点的路径。
 */
public class question257 {
    /**
     * 先序遍历
     */
    private List<String> path = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return path;
    }

    public void dfs(TreeNode root, String str) {
        if(root == null) return;
        StringBuffer sb = new StringBuffer(str);
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            path.add(sb.toString());
        }
        sb.append("->");
        dfs(root.left, sb.toString());
        dfs(root.right, sb.toString());

    }
}
