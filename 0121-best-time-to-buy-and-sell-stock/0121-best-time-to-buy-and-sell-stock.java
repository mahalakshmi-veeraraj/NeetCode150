class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int maxSellingPrice = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxSellingPrice = Math.max(maxSellingPrice, prices[i]);
            maxProfit = Math.max(maxProfit, maxSellingPrice - prices[i]);
        }
        return maxProfit;
    }
}