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
    public TreeNode bstFromPreorder(int[] preOrder) {
        int[] inOrder = new int[preOrder.length];
        for (int i = 0; i < preOrder.length; i++) {
            inOrder[i] = preOrder[i];
        }
        Arrays.sort(inOrder);
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            hashMap.put(inOrder[i], i);
        }
        return construct(inOrder, preOrder, hashMap, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }
    private TreeNode construct(int[] inOrder, int[] preOrder, Map<Integer, Integer> hashMap, int sPre, int ePre, int sIn, int eIn) {
        if(sPre > ePre || sIn > eIn || sPre >= preOrder.length) return null;
        
        int rootNodeValue = preOrder[sPre];
        int rootNodeIndex = hashMap.get(rootNodeValue);
        int leftSubTreeLength = rootNodeIndex - 1 - sIn + 1;
        
        TreeNode rootNode = new TreeNode(rootNodeValue);
        rootNode.left = construct(inOrder, preOrder, hashMap, sPre + 1, sPre + leftSubTreeLength, sIn, rootNodeIndex - 1);
        rootNode.right = construct(inOrder, preOrder, hashMap, sPre + leftSubTreeLength + 1, ePre, rootNodeIndex + 1, eIn);
        return rootNode;
    }
}