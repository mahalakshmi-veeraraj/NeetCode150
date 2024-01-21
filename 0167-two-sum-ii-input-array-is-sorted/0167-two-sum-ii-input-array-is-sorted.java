class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        int sum = 0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }
            else if (sum < target) {
                left++;
            }
            else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1};
    }
}