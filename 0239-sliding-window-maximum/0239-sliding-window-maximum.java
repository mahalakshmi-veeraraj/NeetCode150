class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> doublyEndedQueue = new ArrayDeque<>();
        int totalWindow = nums.length - k;
        int[] answerArray = new int[totalWindow + 1];
        int answerArrayIndex = 0;
        for (int i = 0; i < k; i++) {
            while (!doublyEndedQueue.isEmpty() && nums[doublyEndedQueue.peekLast()] <= nums[i]) {
                doublyEndedQueue.pollLast();
            }
            doublyEndedQueue.addLast(i);
        }
        answerArray[answerArrayIndex++] = nums[doublyEndedQueue.peekFirst()];
        for (int i = 1; i <= totalWindow; i++) {
            if(doublyEndedQueue.peekFirst() == i - 1) {
                doublyEndedQueue.pollFirst();
            }  
            while (!doublyEndedQueue.isEmpty() && nums[doublyEndedQueue.peekLast()] <= nums[i + k - 1]) {
                doublyEndedQueue.pollLast();
            }
            doublyEndedQueue.addLast(i + k - 1);
            answerArray[answerArrayIndex++] = nums[doublyEndedQueue.peekFirst()];
        }
        return answerArray;
    }
}