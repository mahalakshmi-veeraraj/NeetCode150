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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        int bfsQueueSize = 0;
        bfsQueue.add(root);
        
        int sibblingSum = 0;
        int currentLevelSum = root.val;
        int nextLevelSum = 0;
        
        while (!bfsQueue.isEmpty()) {
            bfsQueueSize = bfsQueue.size();
            nextLevelSum = 0;
            for (int i = 0; i < bfsQueueSize; i++) {
                TreeNode peekNode = bfsQueue.poll();
                peekNode.val = currentLevelSum - peekNode.val; // answer = currentLevelSum - sibblingSum.
                
                sibblingSum = 0;
                
                if (peekNode.left != null) {
                    nextLevelSum += peekNode.left.val;
                    sibblingSum += peekNode.left.val;
                    bfsQueue.add(peekNode.left);
                }
                if (peekNode.right != null) {
                    nextLevelSum += peekNode.right.val;
                    sibblingSum += peekNode.right.val;
                    bfsQueue.add(peekNode.right);
                } 
                
                if (peekNode.left !=  null) peekNode.left.val = sibblingSum; // updating the node value as sibbling sum.
                if (peekNode.right != null) peekNode.right.val = sibblingSum;
            }
            
            currentLevelSum = nextLevelSum;
        }
        return root;
    }
}