class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return amount;
        
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return find(dp, coins, amount) == 1000000000 ? -1 : dp[amount];   
    }
    
    private int find (int[] dp, int[] coins, int amount) {
        if (amount <= 0) return 0;
        if (dp[amount] != -1) return dp[amount];
        
        int minNumberOfCoinsNeededToMakeAmount = 1000000000;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) continue;
            minNumberOfCoinsNeededToMakeAmount = Math.min(minNumberOfCoinsNeededToMakeAmount, find(dp, coins, amount - coins[i]) + 1);    
        }
        dp[amount] = minNumberOfCoinsNeededToMakeAmount;
        return dp[amount];
    }
}