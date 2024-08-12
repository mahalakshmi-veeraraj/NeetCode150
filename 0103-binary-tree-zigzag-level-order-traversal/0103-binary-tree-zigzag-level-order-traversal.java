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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listAnswer = new ArrayList<>();
        if (root == null) return listAnswer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int queueSize = 0;
        int zig = 1;
        while (!queue.isEmpty()) {
            queueSize = queue.size();
            List<Integer> listSubAnswer = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode peek = queue.poll();
                listSubAnswer.add(peek.val);
                if (peek.left != null) queue.add(peek.left);
                if (peek.right != null) queue.add(peek.right);
            }
            if (zig == 1) listAnswer.add(listSubAnswer);
            else {
                Collections.reverse(listSubAnswer);
                listAnswer.add(listSubAnswer);
            }
            zig = 1 - zig;
        }
        return listAnswer;
    }
}