package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/29 13:30
 * @description：恢复二叉搜索树,不改变结构
 * @modified By：
 * @version: 1.1
 */
public class question99 {
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //中序遍历,获取list
        //中序遍历二叉搜索树,应该得到的是有序的
        dfs(root, list);
        //找到错误交换的节点
        int[] nums = getSwap(list);
        //先序遍历,交换两个错误节点的值
        dfs2(root, 2, nums[0], nums[1]);
    }

    public int[] getSwap(List<Integer> list){
        int x = -1;
        int y = -1;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) > list.get(i + 1)){
                y = list.get(i + 1);
                if(x == -1){
                    x = list.get(i);
                } else{
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    public void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public void dfs2(TreeNode root,int count , int x, int y){
        if(root != null){
            if(root.val == x || root.val == y){
                root.val = root.val == x?y: x;
                if(--count == 0){
                    return;
                }
            }
            dfs2(root.left, count, x, y);
            dfs2(root.right, count, x, y);
        }
    }
}
