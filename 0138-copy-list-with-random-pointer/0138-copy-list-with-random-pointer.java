/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        // Step1: Insert new node after every node.
        Node current = head;
        while (current != null) {
            Node future = current.next;
            current.next = new Node(current.val);
            current.next.next = future;
            current = future;
        }
        
        // Step2: Point random pointers correctly.
        current = head;
        while (current != null) {
            Node future = current.next;
            if (current.random != null)
                current.next.random = current.random.next;
            current = future.next;
        }
        
        // Decouple the linked list to take the copied linked list.
        Node answerHead = head.next;
        current = head;
        while (current != null) {
            Node future = current.next;
            current.next = future.next;
            if (current.next != null)
                future.next = current.next.next;
            current = current.next;
        }
        
        return answerHead;
    }
}