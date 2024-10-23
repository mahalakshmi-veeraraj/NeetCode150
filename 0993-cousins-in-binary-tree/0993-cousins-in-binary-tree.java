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
    public boolean isCousins(TreeNode root, int x, int y) {
        // x and y are cousin nodes when their level sum is same and their parents are different.
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        int bfsQueueSize = 0;
        TreeNode parentOfXNode = null;
        TreeNode parentOfYNode = null;
        while (!bfsQueue.isEmpty()) {
            bfsQueueSize = bfsQueue.size();
            parentOfXNode = null;
            parentOfYNode = null;
            for (int i = 0; i < bfsQueueSize; i++) {
                TreeNode peekNode = bfsQueue.poll();
                
                if (peekNode.left != null) {
                    if (peekNode.left.val == x) {
                        parentOfXNode = peekNode;
                    }
                    else if (peekNode.left.val == y) {
                        parentOfYNode = peekNode;
                    }
                    bfsQueue.add(peekNode.left);
                }
                if (peekNode.right != null) {
                    if (peekNode.right.val == x) {
                        parentOfXNode = peekNode;
                    }
                    else if (peekNode.right.val == y) {
                        parentOfYNode = peekNode;
                    }
                    bfsQueue.add(peekNode.right);
                }
            }
            if (parentOfXNode != null && parentOfYNode != null && parentOfXNode != parentOfYNode) return true;
        }
        return false;
    }
}