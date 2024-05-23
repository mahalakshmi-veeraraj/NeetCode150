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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> listAnswer = new ArrayList<>();
        if (root == null) return listAnswer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int queueSize = 0;
        while (!queue.isEmpty()) {
            queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode peekNode = queue.poll();
                if (i == queueSize - 1) listAnswer.add(peekNode.val);
                if (peekNode.left != null) queue.add(peekNode.left);
                if (peekNode.right != null) queue.add(peekNode.right);
            }
        }
        return listAnswer;
    }
}