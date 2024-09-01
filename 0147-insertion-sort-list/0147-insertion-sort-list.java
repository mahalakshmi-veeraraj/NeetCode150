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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyNodeHead = dummyNode;
        ListNode current = head;
        while (current != null) {
            ListNode future = current.next;
            current.next = null;
            
            ListNode tempCurrent = dummyNodeHead.next;
            if (tempCurrent != null) {
                boolean isNodeInserted = false;
                ListNode tempPrevious = dummyNodeHead;
                while (tempCurrent != null) {
                    ListNode tempFuture = tempCurrent.next;
                    if (tempCurrent.val > current.val) {
                        tempPrevious.next = current;
                        current.next = tempCurrent;
                        isNodeInserted = true;
                        break;
                    }
                    tempPrevious = tempCurrent;
                    tempCurrent = tempFuture;
                }   
                if (!isNodeInserted) {
                    dummyNode.next = current;
                    dummyNode = dummyNode.next;
                }
            }
            else {
                dummyNode.next = current;
                dummyNode = dummyNode.next;
            }
            
            current = future;
        }
        return dummyNodeHead.next;
    }
}
