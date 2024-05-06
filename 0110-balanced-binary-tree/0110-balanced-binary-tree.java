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
    private boolean isHeightBalanced = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isHeightBalanced;
    }
    private int height(TreeNode root) {
        if (root == null) return 0;

        int lst = height(root.left);
        int rst = height(root.right);
        if (Math.abs(lst - rst) >= 2) {
            isHeightBalanced = false;
        } 
        return Math.max(lst, rst) + 1;
    }
}