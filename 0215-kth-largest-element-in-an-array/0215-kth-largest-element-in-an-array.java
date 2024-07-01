class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        int count = k;
        while (!maxHeap.isEmpty()) {
            int element = maxHeap.poll();
            if (count == 1) return element;
            count--;
        }
        return -1;
    }
}