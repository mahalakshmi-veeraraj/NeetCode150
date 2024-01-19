class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i],0)+1);
        }
        
        Map<Integer, Integer> answerHashMap = hashMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).limit(k).collect (Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        int[] answerArray = new int[k];
        int answerArrayIndex = 0;
        for (int ele : answerHashMap.keySet()) {
            answerArray[answerArrayIndex++] = ele;
        }
        return answerArray;
    }
}