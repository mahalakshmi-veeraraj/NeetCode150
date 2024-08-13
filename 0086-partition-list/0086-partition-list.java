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
    public ListNode partition(ListNode head, int x) {
        ListNode answer1 = new ListNode(-1);
        ListNode answer2 = new ListNode(-1);
        ListNode answer1Head = answer1;
        ListNode answer2Head = answer2;
        ListNode current = head;
        while (current != null) {
            ListNode future = current.next;
            current.next = null;
            if (current.val < x) {
                answer1.next = current;
                answer1 = answer1.next;
            }
            else {
                answer2.next = current;
                answer2 = answer2.next;
            }
            current = future;
        }
        answer1.next = answer2Head.next;
        return answer1Head.next;
    }
}