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
    int totalGoodNodes = 0;
    public int goodNodes(TreeNode root) {
        find(root, Integer.MIN_VALUE);
        return totalGoodNodes;
    }
    private void find (TreeNode root, int maxSoFar) {
        if (root == null) return;
        
        if (maxSoFar <= root.val) totalGoodNodes++;
        
        maxSoFar = Math.max(maxSoFar, root.val);
        find(root.left, maxSoFar);
        find(root.right, maxSoFar);
    }
}