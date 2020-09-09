package dynamicProgramming;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/8 23:29
 * @description：打家劫舍3,在上次打劫完一条街道之后和一圈房屋后，
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * @modified By：
 * @version: 1.1
 */
public class question337 {
    /*
     * @Author liumt
     * @Description 暴力递归,计算爷爷和四个孙子的总和,然后和两个儿子的和,取最大值
     * @Date 23:31 2020/9/8
     * @Param [root]
     * @return int
     **/
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int money = root.val;
        if(root.left != null){
            money += (rob(root.left.left) + rob(root.left.right));
        }
        if(root.right != null){
            money += (rob(root.right.left) + rob(root.right.right));
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }

    /*
     * @Author liumt
     * @Description 使用hashmap存储已经计算过的节点的偷钱树.优化时间复杂度
     * @Date 23:42 2020/9/8
     * @Param [root]
     * @return int
     **/
    public int rob2(TreeNode root) {
        Map<TreeNode, Integer> hash = new HashMap<>();
        return robInterval(root, hash);
    }

    public int robInterval(TreeNode root, Map<TreeNode, Integer> hash){
        if(root == null) return 0;
        if(hash.containsKey(root)) return hash.get(root);
        int money = root.val;
        if(root.left != null){
            money += (robInterval(root.left.left, hash) + robInterval(root.left.right, hash));
        }
        if(root.right != null){
            money += (robInterval(root.right.left, hash) + robInterval(root.right.right, hash));
        }
        int result = Math.max(money,
                robInterval(root.left, hash) + robInterval(root.right, hash));
        hash.put(root, result);
        return result;
    }
}
