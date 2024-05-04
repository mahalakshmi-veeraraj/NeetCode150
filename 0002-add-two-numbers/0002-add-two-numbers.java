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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answerNode = new ListNode(-1);
        ListNode answerNodeHead = answerNode;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            if (sum > 9) {
                answerNode.next = new ListNode(sum % 10);
                carry = sum / 10;
            }
            else {
                answerNode.next = new ListNode(sum);
                carry = 0;
            }
            answerNode = answerNode.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry != 0) {
            answerNode.next = new ListNode(carry);
        }
        return answerNodeHead.next;
    }
}