package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liumt
 * @date Created in 2020/11/11 12:39
 * 出现次数最多的子树元素和
 */
public class question508 {
    /**
     * 统计元素和出现的次数
     */
    Map<Integer, Integer> hashMap = new HashMap<>();
    /**
     * 统计最大次数
     */
    int max = 0;

    /**
     * 后续遍历,元素和=root.val + left + right
     * @param root 根节点
     * @return 根节点的元素和
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (int i: hashMap.keySet()) {
            if (max == hashMap.get(i)) {
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val + left + right;
        if(hashMap.containsKey(sum)) {
            hashMap.put(sum, hashMap.get(sum) + 1);
        } else {
            hashMap.put(sum, 1);
        }
        max = Math.max(hashMap.get(sum), max);
        return sum;
    }
}
