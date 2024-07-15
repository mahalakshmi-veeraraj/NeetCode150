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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> hashMap = new HashMap<>();
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
           
            if (!hashMap.containsKey(parent)) hashMap.put(parent, new TreeNode(parent));
            if (!hashMap.containsKey(child)) hashMap.put(child, new TreeNode(child));
         
            hashSet.add(parent);
            hashSet.add(child);
        }
        for (int i = 0; i < descriptions.length; i++) {
            TreeNode parent = hashMap.get(descriptions[i][0]);
            TreeNode child = hashMap.get(descriptions[i][1]);
            if (descriptions[i][2] == 1) parent.left = child;
            else parent.right = child;
            hashSet.remove(child.val);
        }
        int parent = 0;
        for (Integer key : hashSet) {
            parent = key;
        }
        return hashMap.get(parent);
    }
}