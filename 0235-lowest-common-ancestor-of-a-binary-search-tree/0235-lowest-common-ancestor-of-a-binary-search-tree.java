/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        
        TreeNode leftSubTree = lowestCommonAncestor(root.left, p, q);
        
        TreeNode rightSubTree = lowestCommonAncestor(root.right, p, q);
        
        root.left = leftSubTree;
        root.right = rightSubTree;
        
        if (leftSubTree != null && rightSubTree != null) {
            return root;
        }
        else if (leftSubTree == null && rightSubTree != null) {
            return rightSubTree;
        }
        else if (leftSubTree != null && rightSubTree == null) {
            return leftSubTree;
        }
        else {
            return null;
        }
    }
}