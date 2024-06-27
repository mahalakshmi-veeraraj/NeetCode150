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
    int totalGoodNodes = 1;
    public int goodNodes(TreeNode root) {
        find(root, new ArrayList<>());
        return totalGoodNodes;
    }
    private void find (TreeNode root, List<Integer> listSubAnswer) {
        if (root == null) return;
        
        boolean isIncrement = true; 
        for (Integer node : listSubAnswer) {
            if (node > root.val) {
                isIncrement = false;
                break;
            }
        }
        if (isIncrement && listSubAnswer.size() > 0) totalGoodNodes++;
        
        listSubAnswer.add(root.val);
        find(root.left, listSubAnswer);
        find(root.right, listSubAnswer);
        listSubAnswer.remove(listSubAnswer.size() - 1);
    }
}