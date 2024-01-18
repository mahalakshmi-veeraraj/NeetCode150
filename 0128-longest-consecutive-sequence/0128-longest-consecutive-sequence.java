class Solution {
    public int longestConsecutive(int[] nums) {
        int answer = 0;
        int subAnswer = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]-1)) {
                continue;
            }
            subAnswer = 0;
            int element = nums[i];
            while (hashMap.containsKey(element)) {
                subAnswer++;
                element++;
            }
            answer = Math.max(answer,subAnswer);
        }
        return answer;
    }
}