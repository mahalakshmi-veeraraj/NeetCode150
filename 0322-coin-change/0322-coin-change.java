class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return amount;
        if (coins.length == 1){
            if (coins[0] > amount) return -1;
            else {
                if (amount % coins[0] != 0) return -1;
                else return amount / coins[0];
            }
        }
        
        
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        minCoinsNeeded(coins, dp, amount);
        if (dp[amount] == 1000000000) return -1;
        return dp[amount];
    }
    private int minCoinsNeeded(int[] coins, int[] dp, int amount) {
        if (dp[amount] != -1) return dp[amount];
        
        int minCoinsNeeded = 1000000000;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) continue;
            minCoinsNeeded = Math.min(minCoinsNeeded, minCoinsNeeded(coins, dp, amount - coins[i]) + 1);
        }
        dp[amount] = minCoinsNeeded;
        return dp[amount];
    }
}