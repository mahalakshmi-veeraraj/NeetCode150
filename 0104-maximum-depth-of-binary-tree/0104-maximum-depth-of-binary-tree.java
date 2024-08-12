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
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        // height(root);
        return height(root);
    }
    private int height (TreeNode root) {
        if (root == null) return 0;
        int lst = height(root.left);
        int rst = height(root.right);
        // maxDepth = Math.max(maxDepth, lst + rst);
        return Math.max(lst , rst) + 1;
    }
}