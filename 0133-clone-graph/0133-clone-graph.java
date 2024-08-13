/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> hashMap = new HashMap<>();
        Node clonedGraph = new Node(node.val);
        hashMap.put(node, clonedGraph);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int queueSize = 0;
        while(!queue.isEmpty()) {
            queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node peek = queue.poll();
                Node clone = hashMap.get(peek);
                for (Node neighbor : peek.neighbors) {
                    if (!hashMap.containsKey(neighbor)) {
                        Node clonedNeighbor = new Node(neighbor.val);
                        hashMap.put(neighbor, clonedNeighbor);
                        queue.add(neighbor);
                        clone.neighbors.add(clonedNeighbor);
                    }
                    else {
                        Node clonedNeighbor = hashMap.get(neighbor);
                        clone.neighbors.add(clonedNeighbor);
                    }
                }
            }
        }
        return clonedGraph;
    }
}