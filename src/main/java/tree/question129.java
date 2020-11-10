package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liumt
 * @date Created in 2020/11/10 13:07
 * 计算从根到叶子节点生成的所有数字之和。
 */
public class question129 {
    /**
     * 先序遍历
     */
    private List<String> path = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        dfs(root, "");
        for (String str: path) {
            sum += Integer.valueOf(str);
        }
        return sum;
    }

    public void dfs(TreeNode root, String str) {
        if(root == null) return;
        str = str + root.val;
        if(root.left == null && root.right == null) {
            path.add(str);
        }
        dfs(root.left, str);
        dfs(root.right, str);
    }
}
