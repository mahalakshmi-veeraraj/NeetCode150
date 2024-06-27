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
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> listAnswer = new ArrayList<>();
        List<Integer> listSubAnswer = new ArrayList<>();
        find(listAnswer, listSubAnswer, root);
        List<String> listAns = new ArrayList<>();
        for (int i = 0; i < listAnswer.size(); i++) {
            StringBuilder strBuilder = new StringBuilder();
            for (int j = 0; j < listAnswer.get(i).size(); j++) {
                if (j == listAnswer.get(i).size() - 1) {
                    strBuilder.append(listAnswer.get(i).get(j));
                }
                else {
                    strBuilder.append(listAnswer.get(i).get(j)+"->");
                }
            }
            listAns.add(strBuilder.toString());
        }
        return listAns;
    }
    private void find(List<List<Integer>> listAnswer, List<Integer> listSubAnswer, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            listSubAnswer.add(root.val);
            listAnswer.add(new ArrayList<>(listSubAnswer));
            listSubAnswer.remove(listSubAnswer.size() - 1);
            return;
        }
        listSubAnswer.add(root.val);
        find(listAnswer, listSubAnswer, root.left);
        find(listAnswer, listSubAnswer, root.right);
        listSubAnswer.remove(listSubAnswer.size() - 1);
    }
}