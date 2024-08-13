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
    public boolean hasPathSum(TreeNode root, int targetSum) {
       
        return check(root, targetSum, 0);
    }
    private boolean check (TreeNode root, int targetSum, int sum) {
        if (root == null) return false;
        if (root.val + sum == targetSum && isLeaf(root)) return true;
        if (check(root.left, targetSum, sum + root.val) ||
        check(root.right, targetSum, sum + root.val))
            return true;
        return false;
    }
    private boolean isLeaf (TreeNode node) {
        
        return node != null && node.left == null && node.right == null;
    }
}