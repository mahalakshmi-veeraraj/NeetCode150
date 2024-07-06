class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listAnswer = new ArrayList<>();
        find(listAnswer, nums, 0, new ArrayList<>());
        return listAnswer;
    }
    private void find (List<List<Integer>> listAnswer, int[] nums, int index, List<Integer> listSubAnswer) {
        if (index >= nums.length) {
            listAnswer.add(new ArrayList<>(listSubAnswer));
            return;
        }
        
        // include element.
        listSubAnswer.add(nums[index]);
        find(listAnswer, nums, index + 1, listSubAnswer);
        
        
        
        int nextIndex = index;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                nextIndex = i;
            }else break;
        }
        // exclude element.
        listSubAnswer.remove(listSubAnswer.size() - 1);
        find(listAnswer, nums, nextIndex + 1, listSubAnswer);
    }
}