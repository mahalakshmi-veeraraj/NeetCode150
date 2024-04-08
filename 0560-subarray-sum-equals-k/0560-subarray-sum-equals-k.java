class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int answer = 0;
        int neededValue = 0;
        hashMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            neededValue = sum - k;  
            if (hashMap.containsKey(neededValue)) {
                answer += (hashMap.get(neededValue));
            }
            hashMap.put(sum, hashMap.getOrDefault(sum,0)+1);
        }
        return answer;
    }
}