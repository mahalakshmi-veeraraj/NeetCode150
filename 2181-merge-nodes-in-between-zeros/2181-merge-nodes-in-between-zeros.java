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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        ListNode current = head;
        int sum = 0;
        while (current != null) {
            if (current.val == 0 && sum != 0) {
                ListNode newNode = new ListNode(sum);
                dummy.next = newNode;
                dummy = dummy.next;
                sum = 0;
            }
            sum += current.val;
            current = current.next;
        }
        return dummyHead.next;
    }
}