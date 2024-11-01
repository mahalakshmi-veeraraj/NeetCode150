class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[n][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        long answer = find (coins, n - 1, amount, dp);
        return (int) (answer == Integer.MAX_VALUE ? -1l : answer);
    }
    private long find (int[] coins, int index, int amount, long[][] dp) {
        if (amount == 0) return 0;
        if (index < 0) return Integer.MAX_VALUE;
        if (dp[index][amount] != -1) return dp[index][amount];
        
        // take the coin.
        long take = Integer.MAX_VALUE; 
        if (coins[index] <= amount)
            take = 1 + find (coins, index, amount - coins[index], dp);
            
        // not take the coin.
        long notTake = find (coins, index - 1, amount, dp);
        
        dp[index][amount] = Math.min(take, notTake);    
        return dp[index][amount];
    }
}
