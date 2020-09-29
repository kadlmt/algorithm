package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/29 10:54
 * @description：二叉搜索树中众数(出现频率最高)
 * @modified By：
 * @version: 1.1
 */
public class question501 {
    //当前的节点值
    int current = 0;
    //当前节点值出现的次数
    int count = 0;
    //相同节点出现的最大次数
    int maxCount = 0;
    List<Integer> result = new ArrayList<>();
    /**
     * @Author liumt
     * @Description 中序遍历二叉搜索树,得到的是有序的.可以利用这一特性
     * @Date 11:25 2020/9/29
     * @Param [root]
     * @return int[]
     **/
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] array = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            array[i] = result.get(i);
        }
        return array;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(root.val == current){
            count++;
        } else {
            current = root.val;
            count = 1;
        }
        if(count == maxCount){
            result.add(current);
        }
        if(count > maxCount){
            result.clear();
            result.add(current);
            maxCount = count;
        }
        dfs(root.right);
    }
}
