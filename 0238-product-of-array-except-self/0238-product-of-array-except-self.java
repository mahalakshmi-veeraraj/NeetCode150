class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixArray = new int[n];
        int[] suffixArray = new int[n];
        prefixArray[0] = nums[0];
        suffixArray[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefixArray[i] = prefixArray[i - 1] * nums[i];
            suffixArray[n - i - 1] = suffixArray[n - i] * nums[n - i - 1];
        }
        int[] answerArray = new int[n];
        for (int i = 0; i < n; i++) {
            int leftValue = i == 0 ? 1 : prefixArray[i - 1];
            int rightValue = i == n - 1 ? 1 : suffixArray[i + 1];
            answerArray[i] = leftValue * rightValue;
        }
        return answerArray;
    }
}