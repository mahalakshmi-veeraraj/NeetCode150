class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lisDP = new int[n];
        int[] ldsDP = new int[n];
        for (int i = 0; i < n; i++) {
            lisDP[i] = 1;
            ldsDP[i] = 1;
        }   
        for (int index = 1; index < n; index++) {
            for (int previousIndex = index - 1; previousIndex >= 0; previousIndex--) {
                if (nums[previousIndex] < nums[index]) {
                    lisDP[index] = Math.max(lisDP[index], lisDP[previousIndex] + 1);   
                }
            }
        }
        for (int index = n - 2; index >= 0; index--) {
            for (int previousIndex = index + 1; previousIndex < n; previousIndex++) {
                if (nums[previousIndex] < nums[index]) {
                    ldsDP[index] = Math.max(ldsDP[index], ldsDP[previousIndex] + 1);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        int mountainArrayElements = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int lis = lisDP[i];
            int lds = ldsDP[i];
            if (lis == 1 || lds == 1) continue;
            if ((lis + lds - 1) > mountainArrayElements) {
                mountainArrayElements = lis + lds - 1;
                answer = n - mountainArrayElements;
            }
        }
        return answer;
    }
}