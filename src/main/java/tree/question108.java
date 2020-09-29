package tree;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/29 12:28
 * @description：将有序数组转换成搜索二叉树
 * @modified By：
 * @version: 1.1
 */
public class question108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = (left + right) >> 1;
        //每次选取中间位置作为根节点
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}
