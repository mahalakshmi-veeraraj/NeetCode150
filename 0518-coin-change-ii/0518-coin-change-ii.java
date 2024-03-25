class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for (int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                dp[row][col] = -1;
            }
        }
        return calc(coins, dp, coins.length - 1, amount);
    }
    private int calc (int[] coins, int[][] dp, int index, int amount) {
        // Base case.
        // if (amount == 0) return 1;
        // if (index < 0 || amount < coins[index]) return 0;
        // if (dp[amount][index] != -1) return dp[amount][index];
        if (index == 0) {
             if (amount % coins[0] == 0)
                return 1;
            else
                return 0;
        }   
        if (dp[amount][index] != -1) return dp[amount][index];
        
        // Recurrence Relation.
        int taken = 0;
        if (coins[index] <= amount)
            taken = calc(coins, dp, index, amount - coins[index]);
        int notTaken = calc(coins, dp, index - 1, amount);
        
        dp[amount][index] = taken + notTaken;
        return dp[amount][index];
    }
}