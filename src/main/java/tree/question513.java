package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/27 20:54
 * @description：给定一个二叉树，在树的最后一行找到最左边的值
 * @modified By：
 * @version: 1.1
 */
public class question513 {
    /**
     * @Author liumt
     * @Description 广度优先搜索,只需要找出最后一列的节点的第一个值
     * @Date 20:55 2020/9/27
     * @Param [root]
     * @return int
     **/
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result.get(result.size() - 1).get(0);
    }
}
