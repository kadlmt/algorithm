package tree;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 23:42
 * @description：合并二叉树
 * @modified By：
 * @version: 1.1
 */
public class question617 {
    /*
     * @Author liumt
     * @Description 递归
     * @Date 23:42 2020/8/26
     * @Param [t1, t2]
     * @return tree.TreeNode
     **/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //如果t1为空返回t2
        if(t1 == null)
            return t2;
        //如果t2为空返回t1
        if(t2 == null)
            return t1;
        //都不为空t1=t1+t2
        t1.val = t1.val + t2.val;
        //递归左孩子
        t1.left = mergeTrees(t1.left, t2.left);
        //递归右孩子
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
