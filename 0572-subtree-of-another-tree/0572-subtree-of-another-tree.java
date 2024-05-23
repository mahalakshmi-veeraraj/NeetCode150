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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder rootStrBuilder =  new StringBuilder();
        StringBuilder subRootStrBuilder = new StringBuilder();
        
        preOrderTraversal(root, rootStrBuilder);
        preOrderTraversal(subRoot, subRootStrBuilder);
        System.out.println(rootStrBuilder.toString());
        System.out.println(subRootStrBuilder.toString());
        return rootStrBuilder.toString().indexOf(subRootStrBuilder.toString()) != -1;
    }
    private void preOrderTraversal(TreeNode root, StringBuilder strBuilder) {
        if (root == null) {
            strBuilder.append("null");
            return;
        }
        strBuilder.append("R");
        strBuilder.append(root.val);
        preOrderTraversal(root.left, strBuilder);
        preOrderTraversal(root.right, strBuilder);
    }
}