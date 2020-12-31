package introductionAlgorithm.dataStructure;

/**
 * @author liumt
 * @date Created in 2020/12/30 12:56
 * 二叉树的遍历
 */
public class RootedTree10_4_2 {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 先序遍历
     * @param root 根节点
     */
    public static void dfs(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 中序遍历
     * @param root 根节点
     */
    public static void dfs2(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        System.out.println(root.val);
        dfs(root.right);
    }

    /**
     * 后序遍历
     * @param root 根节点
     */
    public static void dfs3(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(18);
        TreeNode second1 = new TreeNode(7);
        TreeNode second2 = new TreeNode(10);
        root.left = second1;
        root.right = second2;
        TreeNode third1 = new TreeNode(7);
        TreeNode third2 = new TreeNode(4);
        TreeNode third3 = new TreeNode(2);
        TreeNode third4 = new TreeNode(21);
        second1.left = third1;
        second1.right = third2;
        second2.left = third3;
        second2.right = third4;
        TreeNode four1 = new TreeNode(5);
        third2.left = four1;
        dfs(root);
        dfs2(root);
        dfs3(root);
    }
}
