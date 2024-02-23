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
        Map<Integer, Map<Integer, Queue<Integer>>> treeMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));
        while (!queue.isEmpty()) {
            Pair peekPair = queue.poll();
            if (!treeMap.containsKey(peekPair.level)) {
                Queue<Integer> pq = new PriorityQueue<>();
                pq.add(peekPair.node.val);
                TreeMap<Integer, Queue<Integer>> m = new TreeMap<>();
                m.put(peekPair.rowNumber, pq);
                treeMap.put(peekPair.level, m);
            }
            else {
                Map<Integer, Queue<Integer>> m = treeMap.get(peekPair.level);
                if (!m.containsKey(peekPair.rowNumber)) {
                    Queue<Integer> pq = new PriorityQueue<>();
                    pq.add(peekPair.node.val);
                    m.put(peekPair.rowNumber, pq);
                }
                else {
                    Queue<Integer> pq = m.get(peekPair.rowNumber);
                    pq.add(peekPair.node.val);
                }
            }
            if (peekPair.node.left != null) {
                queue.add(new Pair(peekPair.node.left, peekPair.level - 1, peekPair.rowNumber + 1));
            }
            if (peekPair.node.right != null) {
                queue.add(new Pair(peekPair.node.right, peekPair.level + 1, peekPair.rowNumber + 1));
            }
        }
        List<List<Integer>> listAnswer = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, Queue<Integer>>> entry : treeMap.entrySet()) {
            List<Integer> listSubAnswer = new ArrayList<>();
            for (Map.Entry<Integer, Queue<Integer>> e : entry.getValue().entrySet()) {
                Queue<Integer> q = e.getValue();
                while (!q.isEmpty()) {
                    listSubAnswer.add(q.poll());
                }
            }
            
            listAnswer.add(listSubAnswer);
        }
        return listAnswer;
    }
}