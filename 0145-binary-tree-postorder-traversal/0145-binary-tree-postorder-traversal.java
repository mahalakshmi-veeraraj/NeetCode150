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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> listResult = new ArrayList<>();
        traverse(listResult, root);
        return listResult;
    }
    private void traverse (List<Integer> listResult, TreeNode root) {
        if (root == null) return;
        traverse(listResult, root.left);
        traverse(listResult, root.right);
        listResult.add(root.val);
    }
}