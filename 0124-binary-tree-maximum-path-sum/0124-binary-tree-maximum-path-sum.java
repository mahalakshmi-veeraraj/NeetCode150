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
    class MutableInteger {
        int value;
        public MutableInteger(int value) {
            this.value = value;
        }
    }
    public int maxPathSum(TreeNode root) {
        MutableInteger answer = new MutableInteger(Integer.MIN_VALUE);
        findMaxPathSum(root, answer);
        return answer.value;
    }
    private int findMaxPathSum (TreeNode root, MutableInteger answer) {
        if (root == null) return 0;
        
        int maxLeftSubTreePathSum = Math.max(0, findMaxPathSum (root.left, answer));
        int maxRightSubTreePathSum = Math.max(0, findMaxPathSum (root.right, answer));
        answer.value = Math.max(answer.value, root.val + maxLeftSubTreePathSum + maxRightSubTreePathSum);
        return Math.max(maxLeftSubTreePathSum, maxRightSubTreePathSum) + root.val;
    }
}