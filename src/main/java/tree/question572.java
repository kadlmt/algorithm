package tree;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/28 0:04
 * @description：另一个数的子树
 * @modified By：
 * @version: 1.1
 */
public class question572 {
    /*
     * @Author liumt
     * @Description 递归
     * @Date 0:04 2020/8/28
     * @Param [s, t]
     * @return boolean
     **/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null) return true;
        if(s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSametree(s, t);
    }

    public boolean isSametree(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return isSametree(s.left, t.left) && isSametree(s.right, t.right);
    }
}
