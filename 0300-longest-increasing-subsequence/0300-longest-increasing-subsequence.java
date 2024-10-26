class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int index = 0; index < n; index++) {
            dp[index] = 1;
        }
        for (int index = 1; index < n; index++) {
            for (int previousIndex = index - 1; previousIndex >= 0; previousIndex--) {
                if (nums[previousIndex] < nums[index]) {
                    dp[index] = Math.max(dp[index], dp[previousIndex] + 1);
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int index = 0; index < n; index++) {
            answer = Math.max(answer, dp[index]);
        }
        return answer;
    }
}