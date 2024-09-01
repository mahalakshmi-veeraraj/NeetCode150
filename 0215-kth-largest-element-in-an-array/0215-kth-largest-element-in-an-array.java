class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(nums[i]);
            }
            else {
                if (priorityQueue.peek() < nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.add(nums[i]);
                }
            }
        }
        return priorityQueue.peek();
    }
}