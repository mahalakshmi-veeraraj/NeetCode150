class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n <= 1) return nums[0];
        
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        func(dp, nums, n -1);
        return dp[n - 1];
    }
    public int func(int[] dp, int[] nums, int index) {
        if (dp[index] != -1) return dp[index];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i] + func(dp, nums, i - 2), func(dp, nums, i - 1));
        }
        return dp[index];
    } 
}

