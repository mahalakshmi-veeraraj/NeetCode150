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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> listInOrderTraversal = new ArrayList<>();
        inOrderTraversal(listInOrderTraversal, root);
        return listInOrderTraversal.get(k - 1);
    }
    private void inOrderTraversal (List<Integer> listInOrderTraversal, TreeNode root) {
        if (root == null) return;
        inOrderTraversal(listInOrderTraversal, root.left);
        listInOrderTraversal.add(root.val);
        inOrderTraversal(listInOrderTraversal, root.right);
    }
    
}