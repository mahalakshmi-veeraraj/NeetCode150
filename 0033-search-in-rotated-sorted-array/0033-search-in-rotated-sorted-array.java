class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int minElementIndex = minElementIndex(nums);
        int answer = binarySearch(nums, target, 0, minElementIndex - 1);
        if (answer != -1) return answer;
        return binarySearch(nums, target, minElementIndex, n - 1);
    }
    private int minElementIndex (int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[left] > nums[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return left;
    }
    private int binarySearch (int[] nums, int target, int left, int right) {
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return -1;
    }
}
