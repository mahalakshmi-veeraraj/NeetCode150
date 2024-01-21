class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int area = 0;
        int maxArea = 0;
        int w = 0;
        int h = 0;
        // for (int i = 0; i < n; i++) { // Brute Force Approach
        //     for (int j = i + 1; j < n; j++) {
        //         h = Math.min(height[i], height[j]);
        //         w = j - i;
        //         area = h * w;
        //         maxArea = Math.max(area, maxArea);
        //     }
        // }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            h = Math.min(height[left], height[right]);
            w = right - left;
            area = h * w;
            maxArea = Math.max(area, maxArea);
            if (height[left] > height[right]) {
                right--;
            }
            else {
                left++;
            }
        }
        return maxArea;
    }
}