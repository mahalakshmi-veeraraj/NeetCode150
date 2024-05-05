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
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyHead = dummyNode;
        ListNode current = head;
        while (current != null) {
            ListNode kthNode = findKthNode(current, k);
            if (kthNode == null) {
                dummyNode.next = current;
                break;
            }
            ListNode kthNodeNext = kthNode.next;
            kthNode.next = null;
            dummyNode.next = reverseLinkedList(current);
            dummyNode = current;
            current = kthNodeNext;
        }
        return dummyHead.next;
    }
    private ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode future = null;
        while (current != null) {
            future = current.next;
            current.next = previous;
            previous = current;
            current = future;
        }
        return previous;
    }
    private ListNode findKthNode(ListNode head, int k) {
        int i = 0;
        ListNode current = head;
        while (i < k - 1) {
            if (current == null) return current;
            current = current.next;
            i++;
        }
        return current;
    }
}