package tree;

/**
 * @author ：liumt
 * @date ：Created in 2020/11/3 12:38
 * @description：判断平衡二叉树
 * @modified By：
 * @version: 1.1
 */
public class question110 {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode root) {
        //如果到达叶子节点的子节点,则返回高度0
        if(root == null) return 0;
        //获得左子树高度,如果左子树不是平衡返回-1
        int left = depth(root.left);
        if(left == -1) return -1;
        //获得右子树高度,如果右子树不是平衡返回-1
        int right = depth(root.right);
        if(right == -1) return -1;
        //左右子树都是平衡的,左子树高度-右子树高度 > 1返回-1,反之返回max
        return Math.abs(left - right) < 2?Math.max(left, right) + 1: -1;
    }
}
