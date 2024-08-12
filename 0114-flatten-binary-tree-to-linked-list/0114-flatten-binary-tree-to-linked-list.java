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
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
        }
        else if (root.left != null && root.right != null) {
            TreeNode rootRight = root.right;
            root.right = root.left;
            tailNode(root.left).right = rootRight;
            root.left = null;
        }
    }
    private TreeNode tailNode (TreeNode root) {
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }
}