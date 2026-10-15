/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    private StringBuilder str = new StringBuilder();
    private int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return str.toString();    
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return createTree(data);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            str.append('N');
            return;
        }

        str.append(root.val);
        str.append('#');
        dfs(root.left);
        dfs(root.right);
    }

    private TreeNode createTree(String data) {
        if (data.charAt(idx) == 'N') {
            idx++;
            return null;
        } 

        int val = 0;
        while (data.charAt(idx) != '#') {
            val = val * 10 + (data.charAt(idx++) - '0');
        }

        TreeNode node = new TreeNode(val);
        idx++;
        node.left = createTree(data);
        node.right = createTree(data);

        return node;
    }
}
