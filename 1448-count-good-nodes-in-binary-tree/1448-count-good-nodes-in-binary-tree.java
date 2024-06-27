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
        List<Integer> listSubAnswer = new ArrayList<>();
        find(listSubAnswer, root);
        return totalGoodNodes;
    }
    private void find(List<Integer> listSubAnswer, TreeNode root) {
        if (root == null) return;
        if (listSubAnswer.size() > 0) {
            boolean isIncrement = true;
            for (Integer i : listSubAnswer) {
                if (i > root.val) {
                    isIncrement = false;
                    break;
                }
            }
            if (isIncrement) totalGoodNodes++;
        }
        listSubAnswer.add(root.val);
        find(listSubAnswer, root.left);
        find(listSubAnswer, root.right);
        listSubAnswer.remove(listSubAnswer.size() - 1);
    }
}
