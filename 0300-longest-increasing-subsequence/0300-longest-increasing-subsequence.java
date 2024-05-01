class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dpArray = new int[n];
        for (int i = 0; i < n; i++) {
            dpArray[i] = 1;
        }
        int i = 0; 
        int j = 1;
        while (j < n) {
            while (i < j) {
                if (nums[j] > nums[i]) {
                    if (dpArray[i] + 1 > dpArray[j]) {
                        dpArray[j] = dpArray[i] + 1;
                    }
                }
                i++;
            }
            i = 0;
            j++;
        }
        int answer = 0;
        for (i = 0; i < n; i++) {
            answer = Math.max(answer, dpArray[i]);
        }
        return answer;
    }
}