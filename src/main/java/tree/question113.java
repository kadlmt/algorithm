package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/11/4 13:08
 * @description：全路径总和2,找出到叶子节点总和为sum的路径
 * @modified By：
 * @version: 1.1
 */
public class question113 {
    //存放符合条件的路径
    private List<List<Integer>> res = new LinkedList<>();
    //存储当前路径
    private Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int sum) {
        if(root == null) return;
        path.offerLast(root.val);
        if(root.left == null && root.right == null) {
            if(sum == root.val) {
                res.add(new LinkedList<>(path));
            }
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
        path.pollLast();
    }
}
