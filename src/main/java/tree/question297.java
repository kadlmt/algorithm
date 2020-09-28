package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/9/28 13:26
 * @description：二叉树的序列化与反序列化.使用先序遍历
 * @modified By：
 * @version: 1.1
 */
public class question297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dps(root, "");
    }

    public String dps(TreeNode root, String str){
        if(root == null) return str += "NULL,";
        str += root.val + ",";
        str = dps(root.left, str);
        str = dps(root.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(array));
        return dps2(list);
    }

    public TreeNode dps2(List<String> list){
        if(list.get(0).equals("NULL")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = dps2(list);
        root.right = dps2(list);
        return root;
    }
}
