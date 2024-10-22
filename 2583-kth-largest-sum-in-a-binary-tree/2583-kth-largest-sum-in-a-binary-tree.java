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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int queueSize = 0;
        long levelSum = 0;
        Queue<Long> minHeap = new PriorityQueue<>((a, b)-> Long.compare(a, b));
        while (!queue.isEmpty()) {
            queueSize = queue.size();
            levelSum = 0;
            for (int i = 0; i < queueSize; i++) {
                TreeNode peekNode = queue.poll();
                levelSum += peekNode.val;
                if (peekNode.left != null) queue.add(peekNode.left);
                if (peekNode.right != null) queue.add(peekNode.right);
            }
            if (minHeap.isEmpty() || minHeap.size() < k) minHeap.add(levelSum);
            else {
                if (levelSum > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(levelSum);
                }
            }
        }
        if (minHeap.size() < k) return -1;
        return minHeap.poll();
    }
}