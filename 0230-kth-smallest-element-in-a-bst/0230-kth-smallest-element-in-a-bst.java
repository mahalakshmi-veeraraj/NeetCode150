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
    public int kthSmallest(TreeNode root, int k) {
        
        return find(root, k, new MutableInteger(0)).val;
    }
    private TreeNode find (TreeNode root, int k, MutableInteger count) {
        if (root == null) return null;
        
        TreeNode leftSubTree = find (root.left, k, count);
        if (leftSubTree != null) {
            return leftSubTree;
        }
        count.value += 1;
        if (count.value == k) {
            return root;
        }
        return find(root.right, k, count);
    }
}