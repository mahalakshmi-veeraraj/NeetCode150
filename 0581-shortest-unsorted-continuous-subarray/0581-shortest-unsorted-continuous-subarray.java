class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] <= nums[i + 1]) continue;
            startIndex = i;
            break;
        }
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] >= nums[i - 1]) continue;
            endIndex = i;
            break;
        }
        if (startIndex == -1 || endIndex == -1) return 0;
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            minElement = Math.min(minElement, nums[i]);
            maxElement = Math.max(maxElement, nums[i]);
        }
        for (int i = 0; i < startIndex; i++) {
            if (nums[i] > minElement) {
                startIndex = i;
                break;
            }
        }
        for (int i = n - 1; i > endIndex; i--) {
            if (nums[i] < maxElement) {
                endIndex = i;
                break;
            }
        }
        return endIndex - startIndex + 1;
    }
}