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
    public void reorderList(ListNode head) {
        ListNode firstPart = head;
        
        // Calculating the total nodes of a given linked list.
        int totalNode = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            totalNode++;
        }
        
        // Finding the middle node of a given linked list.
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = totalNode % 2 != 0 ? slow : slow.next;
        
        // Reversing the second part of the given linked list.
        ListNode secondPart = reverseLinkedList(middle.next);
        middle.next = null;
        
        // Merging the firstPart and secondPart of the linked list.
        head = mergeNodes(firstPart, secondPart);
    }
    private ListNode reverseLinkedList(ListNode node) {
        ListNode previous = null;
        ListNode current = node;
        ListNode future = null;
        while (current != null) {
            future = current.next;
            current.next = previous;
            previous = current;
            current = future;
        }
        return previous;
    }
    private ListNode mergeNodes(ListNode firstPart, ListNode secondPart) {
        boolean blnFirstPart = true;
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        while (firstPart != null && secondPart != null) {
            if (blnFirstPart) {
                dummy.next = firstPart;
                firstPart = firstPart.next;
                blnFirstPart = false;
            }
            else {
                dummy.next = secondPart;
                secondPart = secondPart.next;
                blnFirstPart = true;
            }
            dummy = dummy.next;
        }
        dummy.next = firstPart;
        return dummyHead.next;
    }
}
