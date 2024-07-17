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
    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int queueSize = 0;
        while (!queue.isEmpty()) {
            queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode peekNode = queue.poll();
                if (peekNode.val == val) return peekNode;
                if (peekNode.left != null) queue.add(peekNode.left);
                if (peekNode.right != null) queue.add(peekNode.right);
            }
        }
        return null;
    }
}