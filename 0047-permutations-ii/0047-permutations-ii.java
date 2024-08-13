class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        List<List<Integer>> listAnswer = new ArrayList<>();
        List<Integer> listSubAnswer = new ArrayList<>();
        find(listAnswer, listSubAnswer, hashMap, nums);
        return listAnswer;
    }
    private void find (List<List<Integer>> listAnswer, List<Integer> listSubAnswer, Map<Integer, Integer> hashMap, int[] nums) {
        if (listSubAnswer.size() == nums.length) {
            listAnswer.add(new ArrayList<>(listSubAnswer));
            return;
        }
        
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 0) {
                listSubAnswer.add(entry.getKey());
                hashMap.put(entry.getKey(), entry.getValue() - 1);
                find(listAnswer, listSubAnswer, hashMap, nums);
                listSubAnswer.remove(listSubAnswer.size() - 1);
                hashMap.put(entry.getKey(), entry.getValue() + 1);
            }
        }
    }
}