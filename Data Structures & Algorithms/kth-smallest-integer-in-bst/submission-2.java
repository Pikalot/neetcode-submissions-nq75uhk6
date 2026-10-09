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

class Solution {
    int step = 0;
    Integer min = null;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return min;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null || min != null) return;

        inorder(root.left, k);
        step++;
        if (step == k) {
            min = root.val;
            return;
        }
        inorder(root.right, k);
    }
}
