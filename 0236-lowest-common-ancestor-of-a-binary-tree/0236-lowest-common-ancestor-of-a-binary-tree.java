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
        return LCA(root, p, q);
    }
    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root.val == p.val) {
            return root;
        }
        else if (root.val == q.val) {
            return root;
        }
        
        TreeNode rootLeft = LCA(root.left, p, q);
        TreeNode rootRight = LCA(root.right, p, q);
        if (rootLeft != null && rootRight != null) {
            return root;
        }
        else if (rootLeft == null && rootRight != null) {
            return rootRight;
        }
        else if (rootRight == null && rootLeft != null) {
            return rootLeft;
        }
        else {
            return null;
        }
    }
}