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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalNode = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            totalNode++;
        }
        
        int removeNodeIndex = n >= totalNode ? n % totalNode : totalNode - n;
        if (removeNodeIndex == 0) return head.next;
        
        totalNode = 0;
        current = head;
        ListNode removeNodePrevious = null;
        ListNode removeNode = null;
        ListNode removeNodeNext = null;
        
        while (current != null) {
            if (totalNode == removeNodeIndex - 1) {
                removeNodePrevious = current;
                removeNode = current.next;
                // if (removeNode != null)
                    removeNodeNext = removeNode.next;
                break;
            }
            current = current.next;
            totalNode++;
        }
        removeNodePrevious.next = removeNodeNext;
        return head;
    }
}