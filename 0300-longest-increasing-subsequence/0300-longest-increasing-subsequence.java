class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        find (nums, dp, 0, -1);
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }
    private int find (int[] nums, int[][] dp, int index, int previousIndex) {
        if (index >= nums.length) return 0;
        
        if (dp[index][previousIndex + 1] != 0) return dp[index][previousIndex + 1];
        
        // Include the element.
        int include = 0;
        if (previousIndex == -1 || nums[index] > nums[previousIndex]) 
            include = find (nums, dp, index + 1, index) + 1;
        
        // Exclude the element.
        int exclude = find (nums, dp, index + 1, previousIndex);
        
        dp[index][previousIndex + 1] = Math.max(include, exclude);
        
        return dp[index][previousIndex + 1];
    }
}