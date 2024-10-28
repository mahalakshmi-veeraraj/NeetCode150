class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int n = nums.length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int root = (int) Math.sqrt(nums[i]);
            if (root * root == nums[i]) dp.put(nums[i], dp.getOrDefault(root, 0) + 1);
            else dp.put(nums[i], 1);
            answer = Math.max(answer, dp.get(nums[i]));
        }
        return answer < 2 ? -1 : answer;
    }
}