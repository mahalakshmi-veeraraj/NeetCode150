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
        public int value;
        public MutableInteger(int value) {
            this.value = value;
        }
    }
    public int maxPathSum(TreeNode root) {
        MutableInteger mutableInteger = new MutableInteger(Integer.MIN_VALUE);
        sum (root, mutableInteger);
        return mutableInteger.value;
    }
    private int sum (TreeNode root, MutableInteger mutableInteger) {
        if (root == null) return 0;
        
        int lst = Math.max(sum(root.left, mutableInteger), 0);
        int rst = Math.max(sum(root.right, mutableInteger), 0);
        mutableInteger.value = Math.max(mutableInteger.value, root.val + lst + rst);
        return Math.max(lst , rst) + root.val;
    }
}