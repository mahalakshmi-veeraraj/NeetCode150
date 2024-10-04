class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int n = nums.length;
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int neededValue = sum - k;
            if (hashMap.containsKey(neededValue)) {
                answer += hashMap.get(neededValue);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum,0) + 1);
        }
        return answer;
    }
}
