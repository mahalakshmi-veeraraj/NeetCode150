class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return find (nums, target, 0, dp);
    }
    private boolean find (int[] nums, int target, int index, int[][] dp) {
        if (target == 0) return true;
        if (index >= nums.length) return false;
        
        if (dp[index][target] != -1) return dp[index][target] == 1;
        
        boolean result = false;
        // include the element.
        if (nums[index] <= target)
            result |= find (nums, target - nums[index], index + 1, dp);
        
        // exclude the element.
        result |= find (nums, target, index + 1, dp);
        dp[index][target] = result ? 1 : 0;
        return result;
    }
}