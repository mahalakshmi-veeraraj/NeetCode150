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
    public boolean isValidBST(TreeNode root) {
        
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean check (TreeNode root, long min, long max) {
        if (root == null) return true;
        
        if (root.val >= min && root.val <= max) {
            return check(root.left, min, (1l * root.val) - 1) && check(root.right, (1l * root.val) + 1, max);
        }
        
        return false;
    }
}