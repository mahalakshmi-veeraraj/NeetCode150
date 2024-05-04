class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int n = nums.length;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        // Finding the starting point of the loop.
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
