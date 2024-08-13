class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> answerSet = new HashSet<>();
        find(answerSet, new ArrayList<>(), nums, 0);
        List<List<Integer>> listAnswer = new ArrayList<>();
        for (List<Integer> key : answerSet) listAnswer.add(key);
        return listAnswer;
    }
    private void find (Set<List<Integer>> answerSet, List<Integer> listSubAnswer, int[] nums, int index) {
        if (index >= nums.length) {
            answerSet.add(new ArrayList<>(listSubAnswer));
            return;
        }
        
        // Include element.
        listSubAnswer.add(nums[index]);
        find(answerSet, listSubAnswer, nums, index + 1);
        
        // Exclude element.
        listSubAnswer.remove(listSubAnswer.size() - 1);
        int i = index + 1;
        while (i < nums.length && nums[i] == nums[index]) {
            i++;
        }
        find(answerSet, listSubAnswer, nums, i);
    }
}