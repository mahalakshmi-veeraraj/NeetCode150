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
        
        // Step 1: Insert a new node after every node in the given linked list.
        Node current = head;
        Node future = null;
        while (current != null) {
            Node newNode = new Node(current.val);
            future = current.next;
            current.next = newNode;
            newNode.next = future;
            current = future;
        } 
        
        // Step 2: Point the random pointers of the newly inserted nodes correctly.
        current = head;
        while (current != null) {
            future = current.next;
            if (current.random != null)
                current.next.random = current.random.next;
            current = future.next;
        }
        
        // Step 3: Decouple the linked list in such a way that part 1 contains the given input linked list and part 2 contains the newly created nodes linked list.
        current = head;
        Node answerNode = head.next;
        while (current != null) {
            future = current.next;
            current.next = future.next;
            if (future.next != null)
                future.next = future.next.next;
            current = current.next;
        }
        
        // Step 4: Return Part 2 as the copied random list.
        return answerNode;
    }
}