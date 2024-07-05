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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null) {
            return new int[]{-1, -1};
        }
        List<Integer> listCriticalPoints = new ArrayList<>();
        ListNode previous = head;
        ListNode current = head.next;
        ListNode future = null;
        int nodePosition = 2;
        while (current != null && current.next != null) {
            future = current.next;
            if (current.val < previous.val && current.val < future.val) {
                System.out.println("local minima "+current.val);
                listCriticalPoints.add(nodePosition);
                System.out.println("critical point "+nodePosition);
            }
            else if (current.val > previous.val && current.val > future.val) {
                System.out.println("local maxima "+current.val);
                System.out.println("critical point "+nodePosition);
                listCriticalPoints.add(nodePosition);
            }
            previous = current;
            current = future;
            nodePosition++;
        }
        if (listCriticalPoints.size() == 0) return new int[]{-1, -1};
        Collections.sort(listCriticalPoints);
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        for (int i = 0; i < listCriticalPoints.size() - 1; i++) {
            int val = Math.abs(listCriticalPoints.get(i) - listCriticalPoints.get(i + 1));
            minDistance = Math.min(minDistance, val);
        }
        maxDistance = Math.max(maxDistance, listCriticalPoints.get(listCriticalPoints.size() - 1) - listCriticalPoints.get(0));
        if (maxDistance == Integer.MIN_VALUE || minDistance == Integer.MAX_VALUE) {
            return new int[]{-1,-1};
        }
        return new int[]{minDistance, maxDistance};
    }
}

// [5,3,1,2,5,1,2]
// 1 - local minima - node position 3
// 5 - local maxima - node position 5
// 1 - local minima - node position 6
