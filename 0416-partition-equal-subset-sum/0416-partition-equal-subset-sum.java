class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for (int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                dp[row][col] = -1;
            }
        }
        return find(nums, target, 0, dp) == 1;
    }
    private int find (int[] nums, int target, int index, int[][] dp) {
        if (target == 0) return 1;
        if (index >= nums.length) return 0;
        if (dp[index][target] != -1) return dp[index][target];
        if (nums[index] > target) {
            
            dp[index][target] = find(nums, target, index + 1, dp);
            return dp[index][target];
        }
        int answer1 = find (nums, target - nums[index], index + 1, dp);
        int answer2 = find(nums, target, index + 1, dp);
        dp[index][target] = answer1 == 1 || answer2 == 1 ? 1 : 0;
        return dp[index][target];
    }
}