class Solution {
    public int search(int[] nums, int target) {
        int minElementIndex = findMin(nums);
        System.out.println(minElementIndex);
        int answer = binarySearch(nums, 0, minElementIndex - 1, target);
        if (answer == -1) {
            answer = binarySearch(nums, minElementIndex, nums.length - 1, target);
        }
        return answer;
    }
    private int findMin (int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;
        while (low < high) {
            middle = (low + high) / 2;
            if (nums[middle] <= nums[high]) high = middle;
            else low = middle + 1;
        }
        return low;
    }
    private int binarySearch (int[] nums, int low, int high, int target) {
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] == target) return middle;
            else if (nums[middle] > target) high = middle - 1;
            else low = middle + 1;
        } 
        return -1;
    }
}
