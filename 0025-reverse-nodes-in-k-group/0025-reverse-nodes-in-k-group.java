/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode previous = null;
        ListNode answerNode = null;
        while (current != null) {
            ListNode kthNode = findKthNode(current, k);
            if (kthNode == null) {
                previous.next = current;
                break;
            }
            ListNode kthNodeNext = kthNode.next;
            kthNode.next = null;
            ListNode reversedNode = reverse(current);
            if (answerNode == null) answerNode = reversedNode;
            if (previous != null) previous.next = kthNode;
            previous = current;
            current = kthNodeNext;
        }
        return answerNode;
    }
    private ListNode findKthNode (ListNode node, int k) {
        ListNode current = node;
        int count = 1;
        while (count < k) {
            if (current == null) break;
            current = current.next;
            count++;
        }
        return current;
    }
    private ListNode reverse (ListNode node) {
        ListNode current = node;
        ListNode previous = null;
        ListNode future = null;
        while (current != null) {
            future = current.next;
            current.next = previous;
            previous = current;
            current = future;
        }
        return previous;
    }
}