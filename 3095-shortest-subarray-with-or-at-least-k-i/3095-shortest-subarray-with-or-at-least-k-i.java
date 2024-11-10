class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
         // Brute Force Approach - Time Complexity O(N^2) - Got TLE.
        int subAnswer = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            subAnswer = 0;
            for (int j = i; j < n; j++) {
                subAnswer |= nums[j];
                if (subAnswer >= k) {
                    answer = Math.min(answer, j - i + 1);
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}