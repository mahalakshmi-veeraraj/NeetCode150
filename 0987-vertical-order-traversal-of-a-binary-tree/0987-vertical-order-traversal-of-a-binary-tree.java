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
    class Pair {
        TreeNode node;
        int level;
        int rowNumber;
        public Pair (TreeNode node, int level, int rowNumber) {
            this.node = node;
            this.level = level;
            this.rowNumber = rowNumber;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> treeMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));
        while (!queue.isEmpty()) {
                Pair peek = queue.poll();
                TreeNode peekNode = peek.node;
                if (treeMap.containsKey(peek.level)) {
                    Map<Integer, List<Integer>> map = treeMap.get(peek.level);
                    List<Integer> list = null;
                    if (map.containsKey(peek.rowNumber)) {
                        list = map.get(peek.rowNumber);
                    }else list = new ArrayList<>();
                    list.add(peekNode.val);
                    map.put(peek.rowNumber, list);
                }
                else {
                    Map<Integer, List<Integer>> map = new TreeMap<>();
                    List<Integer> list = new ArrayList<>();
                    list.add(peekNode.val);
                    map.put(peek.rowNumber, list);
                    treeMap.put(peek.level, map);
                }
                if (peekNode.left != null) queue.add(new Pair(peekNode.left, peek.level - 1, peek.rowNumber + 1));
                if (peekNode.right != null) queue.add(new Pair(peekNode.right, peek.level + 1, peek.rowNumber + 1));
        }
        List<List<Integer>> listAnswer = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer,List<Integer>>> entry : treeMap.entrySet()) {
            List<Integer> listSubAnswer = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> subEntry : entry.getValue().entrySet()) {
                Collections.sort(subEntry.getValue());
                listSubAnswer.addAll(subEntry.getValue());
            }
            listAnswer.add(listSubAnswer);
        }
        return listAnswer;
    }
}
