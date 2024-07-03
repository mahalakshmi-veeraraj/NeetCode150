class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        Arrays.sort(nums);
        int n = nums.length;      
        int option1 = nums[n - 4] - nums[0];
        int option2 = nums[n - 3] - nums[1];
        int option3 = nums[n - 2] - nums[2];
        int option4 = nums[n - 1] - nums[3];
        return Math.min(Math.min(option1, option2), Math.min(option3, option4));
    }
}


// 1, 5, 0, 10, 14

// 0, 1, 5, 10, 14

// nums[n - 4] - nums[0]
// nums[n - 3] - nums[1]
// nums[n - 2] - nums[2]
// nums[n - 1] - nums[3]
