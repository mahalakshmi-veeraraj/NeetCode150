class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        int answer = 0;
        while (!priorityQueue.isEmpty()) {
            if (k == 0) return answer;
            answer = priorityQueue.poll();
            k--;
        }
        return answer;
    }
}