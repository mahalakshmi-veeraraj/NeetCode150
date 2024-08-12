class Solution {
    public int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        int carry = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + carry;
            carry = sum < 0 ? 0 : sum;
            answer = Math.max(answer, sum);
        }
        return answer == Integer.MIN_VALUE ? -1 : answer;
    }
}