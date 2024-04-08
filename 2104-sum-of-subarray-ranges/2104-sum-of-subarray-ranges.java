class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;
        int maxElement = 0;
        int minElement = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                maxElement = nums[i];
                minElement = nums[i];
                for (int k = i; k <= j; k++) {
                    maxElement = Math.max(maxElement, nums[k]);
                    minElement = Math.min(minElement, nums[k]);
                }
                sum = sum + (maxElement - minElement);
            }
        }
        return sum;
    }
}