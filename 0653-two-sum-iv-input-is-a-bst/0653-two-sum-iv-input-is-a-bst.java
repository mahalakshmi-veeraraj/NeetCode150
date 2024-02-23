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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> hashSet = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode peekNode = queue.poll();
            int neededValue = k - peekNode.val;
            if (hashSet.contains(neededValue)) return true;
            hashSet.add(peekNode.val);
            if (peekNode.left != null) {
                queue.add(peekNode.left);
            }
            if (peekNode.right != null) {
                queue.add(peekNode.right);
            }
        }
        return false;
    }
}