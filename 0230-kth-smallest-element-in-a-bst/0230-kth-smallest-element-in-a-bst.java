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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        return find(root, k).val;
    }
    private TreeNode find (TreeNode root, int k) {
        if (root == null) return null;
        
        TreeNode leftSubTree = find (root.left, k);
        if (leftSubTree != null) {
            return leftSubTree;
        }
        count++;
        if (count == k) {
            return root;
        }
        TreeNode rightSubTree = find(root.right, k);
        if (rightSubTree != null) {
            return rightSubTree;
        }
        return null;
    }
}