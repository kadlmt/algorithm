package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/27 12:58
 * @description：二叉树的层平均值
 * @modified By：
 * @version: 1.1
 */
public class question637 {
    /**
     * @Author liumt
     * @Description 广度优先搜索
     * @Date 12:59 2020/9/27
     * @Param [root]
     * @return java.util.List<java.lang.Double>
     **/
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Double sum = 0.0;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                sum += node.val;
            }
            avg.add(sum / size);
        }
        return avg;
    }
}
