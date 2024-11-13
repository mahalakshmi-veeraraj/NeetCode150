class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // Brute Force Approach: Time Complexity: O(N ^ 2) and Space Complexity: O(1).
        long answer = 0;
        int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         if (nums[i] + nums[j] >= lower && nums[i] + nums[j] <= upper) answer++;
        //     }
        // }
        // return answer;
        // Optimal Approach: Sorting and Binary Searching Algorithm. Time Complexity: O(NLogN) and Space Complexity: O(1)
        // Step1 : Sort the array.
        Arrays.sort(nums);
        int fromValue = 0;
        int toValue = 0;
        int fromIndex = 0;
        int toIndex = 0;
        int low = 0;
        int high = 0;
        int middle = 0;
        for (int i = 0; i < n; i++) {
            fromValue = lower - nums[i];
            toValue = upper - nums[i];
            fromIndex = -1;
            toIndex = -1;
            // Apply binary search to find the from Index;
            low = i + 1;
            high = n - 1;
            while (low <= high) {
                middle = (low + high) / 2;
                if (nums[middle] < fromValue) low = middle + 1;
                else {
                    fromIndex = middle;
                    high = middle - 1;
                }
            }
            // Apply binary search to find the to Index;
            low = i + 1;
            high = n - 1;
            while (low <= high) {
                middle = (low + high) / 2;
                if (nums[middle] > toValue) high = middle - 1;
                else {
                    toIndex = middle;
                    low = middle + 1;
                }
            }
            if (fromIndex != -1 && toIndex != -1)
                answer = answer + (toIndex - fromIndex + 1);
        }
        return answer;
    }
}