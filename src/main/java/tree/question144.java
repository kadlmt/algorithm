package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/28 7:43
 * @description：遍历
 * @modified By：
 * @version: 1.1
 */
public class question144 {
    /**
     * @Author liumt
     * @Description 前序遍历
     * @Date 7:52 2020/9/28
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    /**
     * @Author liumt
     * @Description 中序遍历
     * @Date 7:52 2020/9/28
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs2(root, list);
        return list;
    }

    /**
     * @Author liumt
     * @Description 后序遍历
     * @Date 7:55 2020/9/28
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs3(root, list);
        return list;
    }

    public void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    public void dfs2(TreeNode root, List<Integer> list){
        if(root == null) return;
        dfs2(root.left, list);
        list.add(root.val);
        dfs2(root.right, list);
    }

    public void dfs3(TreeNode root, List<Integer> list){
        if(root == null) return;
        dfs3(root.left, list);
        dfs3(root.right, list);
        list.add(root.val);
    }
}
