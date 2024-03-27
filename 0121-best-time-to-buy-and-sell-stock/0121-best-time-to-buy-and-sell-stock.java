class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int maxSellingPrice = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            maxSellingPrice = Math.max(maxSellingPrice, prices[i]);
            maxProfit = Math.max(maxProfit, maxSellingPrice - prices[i]);
        }
        return maxProfit;
    }
}