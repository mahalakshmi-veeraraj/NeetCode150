class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n <= 1) return nums[0];
        int low = 0;
        int high = n - 1;
        int middle = 0;
        while (low < high) {
            middle = (low + high) / 2;
            if (nums[middle] <= nums[high]) {
                high = middle;
            }
            else {
                low = middle + 1;
            }
        }
        return nums[low];
    }
}
