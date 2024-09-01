class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        int carry = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = carry + nums[i] ;
            if (sum < 0) carry = 0;
            else carry = sum;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}