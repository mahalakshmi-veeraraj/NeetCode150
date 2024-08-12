class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = 0;
        int vote = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (vote == 0) {
                majorityElement = nums[i];
                vote++;
            }
            else if (majorityElement == nums[i]) {
                vote++;
            }
            else {
                vote--;
                if (vote == 0) {
                    majorityElement = nums[i];
                }
            }
        }
        return majorityElement;
    }
}