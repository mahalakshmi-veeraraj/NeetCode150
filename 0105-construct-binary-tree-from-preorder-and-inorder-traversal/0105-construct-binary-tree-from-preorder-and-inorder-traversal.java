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
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return construct(preorder, inorder, inOrderMap, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode construct(int[] preorder, int[] inorder, Map<Integer, Integer> inOrderMap, int sPre, int ePre, int sIn, int eIn) {
        if (sIn > eIn || sPre > ePre) return null;
        int rootNodeValue = preorder[sPre];
        int rootNodeIndex = inOrderMap.get(rootNodeValue);
        int lstLength = rootNodeIndex - sIn;
        TreeNode root = new TreeNode(rootNodeValue);
        root.left = construct(preorder, inorder, inOrderMap, sPre + 1, sPre + lstLength, sIn, rootNodeIndex - 1);
        root.right = construct(preorder, inorder, inOrderMap, sPre + lstLength + 1, ePre, rootNodeIndex + 1, eIn);
        return root;
    }
}