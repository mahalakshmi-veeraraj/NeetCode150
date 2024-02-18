class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int totalWindows =  n - k;
        int[] answerArray = new int[totalWindows + 1];
        int answerArrayIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        answerArray[answerArrayIndex++] = nums[deque.peekFirst()];
        int inElement = 0;
        for (int i = 1; i <= totalWindows; i++) {
            if (deque.peekFirst() == i - 1) {
                deque.pollFirst();
            }
            inElement = nums[k + i - 1];
            while (!deque.isEmpty() && nums[deque.peekLast()] < inElement) {
                deque.pollLast();
            }
            deque.addLast(k + i - 1);
            answerArray[answerArrayIndex++] = nums[deque.peekFirst()];
        }
        return answerArray;
    }
}