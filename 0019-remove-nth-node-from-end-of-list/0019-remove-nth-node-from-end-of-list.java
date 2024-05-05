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
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        for (int i = 0; i < n; i++) {
            pointer2 = pointer2.next;
        }
        if (pointer2 == null) return pointer1.next;
        while (pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        pointer1.next = pointer1.next.next;
        return head;
    }
}