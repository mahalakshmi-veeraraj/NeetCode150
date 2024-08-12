/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int queueSize = 0;
        while (!queue.isEmpty()) {
            queueSize = queue.size();
            Node previous = null;
            for (int i = 0; i < queueSize; i++) {
                Node peek = queue.poll();
                if (previous != null)
                    previous.next = peek;
                previous = peek;
                if (peek.left != null) queue.add(peek.left);
                if (peek.right != null) queue.add(peek.right);
            }
        }
        return root;
    }
}