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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return construct(preorder, inorder, inorderMap, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode construct (int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int sPre, int ePre, int sIn, int eIn) {
        if (sPre > ePre || sIn > eIn) return null;
        
        int rootNode = preorder[sPre];
        int rootNodeIndex = inorderMap.get(rootNode);
        int leftSubtreeLength = rootNodeIndex - 1 - sIn + 1;
        TreeNode root = new TreeNode(rootNode);
        root.left = construct(preorder, inorder, inorderMap, sPre + 1, sPre + leftSubtreeLength, sIn, rootNodeIndex - 1);
        root.right = construct(preorder, inorder, inorderMap, sPre + leftSubtreeLength + 1, ePre, rootNodeIndex + 1, eIn);
        return root;
    }
}