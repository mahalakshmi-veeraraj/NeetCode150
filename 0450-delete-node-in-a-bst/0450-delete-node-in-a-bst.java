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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        else {
            if (root.left == null && root.right == null) {
                return null;
            }
            else if (root.left == null || root.right == null) {
                return root.left != null ? root.left : root.right;
            }
            else {
                TreeNode newRoot = smallestInRST(root.right, root.right);    
                newRoot.right = deleteNode(root.right, newRoot.val);
                newRoot.left = root.left;
                return newRoot;
            }
        }
        return root;
    }
    private TreeNode smallestInRST(TreeNode root, TreeNode rootParent) {
        if (root == null) return rootParent;
        
        return smallestInRST(root.left, root);
    }
}