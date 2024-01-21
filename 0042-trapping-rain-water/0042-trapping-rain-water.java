class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = height[0];
        suffixMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = prefixMax[i - 1] > height[i] ? prefixMax[i - 1] : height[i];
            suffixMax[n - i - 1] = suffixMax[n - i] > height[n - i - 1] ? suffixMax[n - i] : height[n - i - 1];
        }
        int totalRainWaterTrapped = 0;
        int support = 0;
        for (int i = 1; i < n - 1; i++) {
            support = Math.min(prefixMax[i - 1], suffixMax[i + 1]);
            if (support < height[i]) continue;
            totalRainWaterTrapped += (support - height[i]);
        }
        return totalRainWaterTrapped;
    }   
}