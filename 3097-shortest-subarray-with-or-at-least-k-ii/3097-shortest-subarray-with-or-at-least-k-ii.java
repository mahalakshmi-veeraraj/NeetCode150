class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int i = 0; 
        int j = 0;
        int answer = Integer.MAX_VALUE;
        int[] bitArray = new int[32];
        while (j < n) {
            updateContribution(bitArray, nums[j], true);
            while (isContributionMoreThanEqualToK(bitArray, k) && i <= j) {
                updateContribution(bitArray, nums[i], false);
                answer = Math.min(answer, j - i + 1);
                i++;
            }
            j++;
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    private void updateContribution (int[] bitArray, int num, boolean add) {
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                bitArray[i] = bitArray[i] + (add ? 1 : -1);
            }
        }
    }
    private boolean isContributionMoreThanEqualToK (int[] bitArray, int k) {
        int bitValue = 0;
        for (int i = 0; i < bitArray.length; i++) {
            bitValue += ( (bitArray[i] == 0 ? 0 : 1) * Math.pow(2, i) ); 
        }
        return bitValue >= k;
    }
}