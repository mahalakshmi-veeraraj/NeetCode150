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
    String locToStart;
    String locToEnd;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Step 1: Find the Lowest Common Ancestor (LCA).
        TreeNode lca = lca(root, startValue, destValue);
        
        StringBuilder ansSB = new StringBuilder();
        dfs(lca, startValue, destValue, ansSB);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < locToStart.length(); i++) {
            // if (locToStart.charAt(i) == 'L')
                sb.append("U");
            // else sb.append(locToStart.charAt(i));
        }
        
        return sb.toString() + locToEnd;
    }
    
    private TreeNode lca(TreeNode root, int startValue, int destValue) {
        if (root == null) return root;
        
        else if (root.val == startValue || root.val == destValue) return root;
        
        TreeNode rootLeft = lca(root.left, startValue, destValue);
        TreeNode rootRight = lca(root.right, startValue, destValue);
        if (rootLeft != null && rootRight != null) return root;
        else if (rootLeft != null && rootRight == null) return rootLeft;
        else if (rootLeft == null && rootRight != null) return rootRight;
        else return null;
    }
    
    private void dfs(TreeNode node, int startValue, int destValue, StringBuilder sb) {
        if (node == null) return;
        if (node.val == startValue) locToStart = sb.toString();
        if (node.val == destValue) locToEnd = sb.toString();
        
        sb.append("L");
        dfs(node.left, startValue, destValue, sb);
        sb.deleteCharAt(sb.length()-1);
        
        sb.append("R");
        dfs(node.right, startValue, destValue, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}