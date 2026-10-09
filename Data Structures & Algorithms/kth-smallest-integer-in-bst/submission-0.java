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
    int min = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return min;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;

        inorder(root.left, k);
        step++;
        if (step == k) min = root.val;
        inorder(root.right, k);
    }
}
