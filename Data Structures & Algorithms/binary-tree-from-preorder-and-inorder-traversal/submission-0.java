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

 /**
p   1   2   3   4
                i
    
i   2   1   3   4
    s   d       e
    ex       s
ex       sxex   sx   
map 1:1 2:0 3:2 4:3

node    1
        2       3
        n  n    n   4
 */


class Solution {
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, map, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> map, int s, int e) {
        if (s > e) return null;

        int j = map.get(preorder[idx]);
        TreeNode node = new TreeNode(preorder[idx++]);
        node.left = buildTree(preorder, inorder, map, s, j - 1);
        node.right = buildTree(preorder, inorder, map, j + 1, e);

        return node;
    }
}
