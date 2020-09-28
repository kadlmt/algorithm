package tree;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/29 7:45
 * @description：二叉树剪枝
 * @modified By：
 * @version: 1.1
 */
public class question814 {
    /**
     * @Author liumt
     * @Description 后序遍历
     * @Date 7:46 2020/9/29
     * @Param [root]
     * @return tree.TreeNode
     **/
    public TreeNode pruneTree(TreeNode root) {
        return dps(root, 1)?root: null;
    }

    public boolean dps(TreeNode root, int value){
        if(root == null) return false;
        boolean left = dps(root.left, value);
        boolean right = dps(root.right, value);
        if(!left) root.left = null;
        if(!right) root.right = null;
        return left || right || root.val == value;
    }
}
