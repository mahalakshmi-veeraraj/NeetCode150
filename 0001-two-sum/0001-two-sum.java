class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int neededValue = target - nums[i];
            if (hashMap.containsKey(neededValue)) {
                return new int[] {hashMap.get(neededValue), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1};
    }
}