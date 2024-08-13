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
        ListNode answerNode = new ListNode(-1);
        ListNode answerNodeHead = answerNode;
        ListNode current = head;
        while (current != null) {
            ListNode kthNode = findKthNode(current, k);
            //System.out.println("kthNode value is "+kthNode.val);
            if (kthNode == null) {
                answerNode.next = current;
                break;
            }
            ListNode future = kthNode.next;
            kthNode.next = null;
            ListNode reversedKthNode = reverse(current);
            answerNode.next = reversedKthNode;
            answerNode = tailNode(reversedKthNode);
            current = future;
        }
        return answerNodeHead.next;
    }
    private ListNode reverse (ListNode head) {
        ListNode current = head;
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
    private ListNode findKthNode (ListNode node, int k) {
        int count = 0;
        while (node != null) {
            count++;
            if (count == k) return node;
            node = node.next;
        }
        return null;
    }
    private ListNode tailNode (ListNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}