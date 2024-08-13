class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;
            while (nums[i] - 1 >= 0 && nums[i] != i + 1) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;
            return i + 1;
        }
        return 0;
    }
}

//3, 0, 1
//9, 6, 4, 2, 3, 5, 7, 0, 1

//0, 1, 2, 3, 4, 5, 6, 7, 8, 9
//9, 6, 4, 2, 3, 5, 7, 0, 1

// 0, 1, 2, 3, 4, 5, 6, 7, 9
