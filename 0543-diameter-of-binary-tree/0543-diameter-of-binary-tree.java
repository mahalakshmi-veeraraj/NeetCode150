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
    int answer = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return answer;
    }
    private int height(TreeNode root) {
        if (root == null) return 0;
        
        int lst = height(root.left);
        int rst = height(root.right);
        answer = Math.max(answer, lst + rst);
        return Math.max(lst, rst) + 1;
    }
}