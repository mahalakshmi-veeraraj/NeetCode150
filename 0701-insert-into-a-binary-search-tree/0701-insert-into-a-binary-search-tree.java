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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        insert(root, root, val);
        return root;
    }
    private void insert (TreeNode root, TreeNode parent, int val) {
        if (root == null || root.left == null && root.right == null) {
            TreeNode newNode = new TreeNode(val);
            TreeNode n = root == null ? parent : root;
            if (n.val > val)
                n.left = newNode;
            else
                n.right = newNode;
            return;
        }
        
        if (root.val > val) {
            insert(root.left, root, val);
        }
        else {
            insert(root.right, root, val);
        }
    }
}