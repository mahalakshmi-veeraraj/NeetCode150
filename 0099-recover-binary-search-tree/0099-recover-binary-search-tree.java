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
    int pointer = 0;
    public void recoverTree(TreeNode root) {
        List<Integer> listInorder = new ArrayList<>();
        inOrderTraversal(root, listInorder);
        Collections.sort(listInorder);
        updateTree(root, listInorder);
    }
    private void updateTree(TreeNode root, List<Integer> listAnswer) {
        if (root == null) return;
        updateTree(root.left, listAnswer);
        root.val = listAnswer.get(pointer++);
        updateTree(root.right, listAnswer);
    }
    private void inOrderTraversal(TreeNode root, List<Integer> listInorder) {
        if (root == null) return;
        inOrderTraversal(root.left, listInorder);
        listInorder.add(root.val);
        inOrderTraversal(root.right, listInorder);
    }
}