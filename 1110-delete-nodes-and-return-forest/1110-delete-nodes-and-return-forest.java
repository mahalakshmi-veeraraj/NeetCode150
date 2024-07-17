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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) hashSet.add(to_delete[i]);
        List<TreeNode> listAnswer = new ArrayList<>();
        find(listAnswer, root, hashSet, true);
        return listAnswer;
    }
    private void find (List<TreeNode> listAnswer, TreeNode root, Set<Integer> hashSet, boolean isRoot) {
        if (root == null) return;
        if (hashSet.contains(root.val)) {
            find(listAnswer, root.left, hashSet, true);
            find(listAnswer, root.right, hashSet, true);
        }
        else {
            if (isRoot) {
                listAnswer.add(root);
            }
            TreeNode rootLeft = root.left;
            TreeNode rootRight = root.right;
            if (root.left != null && hashSet.contains(root.left.val)) {
                root.left = null;
            }
            if (root.right != null && hashSet.contains(root.right.val)) {
                root.right = null;
            }
            find(listAnswer, rootLeft, hashSet, false);
            find(listAnswer, rootRight, hashSet, false);
        }
    }
}