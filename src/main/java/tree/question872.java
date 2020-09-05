package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/5 23:48
 * @description：叶子相似的树
 * @modified By：
 * @version: 1.1
 */
public class question872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    /*
     * @Author liumt
     * @Description 深度优先搜索,把所有叶子节点放入list
     * @Date 23:48 2020/9/5
     * @Param [root, list]
     * @return void
     **/
    public void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        //叶子节点的条件
        if(root.left == null && root.right == null) list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
