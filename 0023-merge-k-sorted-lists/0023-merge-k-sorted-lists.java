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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        return mergeSort(lists, 0, lists.length - 1);
    }
    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        
        int mid = (start + end) / 2;
        ListNode nodeA =  mergeSort(lists, start, mid);
        ListNode nodeB = mergeSort(lists, mid + 1, end);
        return merge(nodeA, nodeB);
    }
    private ListNode merge(ListNode nodeA, ListNode nodeB) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val < nodeB.val) {
                dummy.next = nodeA;
                nodeA = nodeA.next;
            }
            else {
                dummy.next = nodeB;
                nodeB = nodeB.next;
            }
            dummy = dummy.next;
        }
        while (nodeA != null) {
            dummy.next = nodeA;
            nodeA = nodeA.next;
            dummy = dummy.next;
        }
        while (nodeB != null) {
            dummy.next = nodeB;
            nodeB = nodeB.next;
            dummy = dummy.next;
        }
        return dummyHead.next;
    }
}