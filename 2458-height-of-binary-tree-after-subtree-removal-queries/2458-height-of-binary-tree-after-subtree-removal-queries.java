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
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = 100001;
        int[] levelArray = new int[n];
        int[] heightArray = new int[n];
        int[][] levelWiseTop2HeightArray = new int[n][2];
        height(root, levelArray, heightArray, 0, levelWiseTop2HeightArray);
        int levelValue = 0;
        int heightValue = 0;
        int[] answerArray = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            levelValue = levelArray[queries[i]];
            heightValue = heightArray[queries[i]];
            if (levelWiseTop2HeightArray[levelValue][0] == heightValue) {
                heightValue = levelWiseTop2HeightArray[levelValue][1];
            }
            else {
                heightValue = levelWiseTop2HeightArray[levelValue][0];
            }
            answerArray[i] = (heightValue + levelValue) - 1;
        }
        return answerArray;
    }
    private int height(TreeNode root, int[] levelArray, int[] heightArray, int level, int[][] levelWiseTop2HeightArray) {
        if (root == null) return 0;
        
        int lst = height(root.left, levelArray, heightArray, level + 1, levelWiseTop2HeightArray);
        int rst = height(root.right, levelArray, heightArray, level + 1, levelWiseTop2HeightArray);
        int rootHeight = Math.max(lst, rst) + 1;
        
        levelArray[root.val] = level;
        heightArray[root.val] = rootHeight;
        if (rootHeight >= levelWiseTop2HeightArray[level][0]) {
            levelWiseTop2HeightArray[level][1] = levelWiseTop2HeightArray[level][0];
            levelWiseTop2HeightArray[level][0] = rootHeight;
        }
        else if (rootHeight >= levelWiseTop2HeightArray[level][1]) {
            levelWiseTop2HeightArray[level][1] = rootHeight;
        }
        
        return rootHeight;
    }
}