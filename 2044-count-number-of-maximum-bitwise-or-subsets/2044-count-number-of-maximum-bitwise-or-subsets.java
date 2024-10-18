class Solution {
    public int countMaxOrSubsets(int[] nums) {
        List<List<Integer>> listAnswer = new ArrayList<>();
        List<Integer> listSubAnswer = new ArrayList<>();
        findSubsets(listAnswer, listSubAnswer, nums, 0);
        int or = 0;
        int maxOr = 0;
        int answer = 0;
        for (int i = 0; i < listAnswer.size(); i++) {
            listSubAnswer = listAnswer.get(i);
            or = 0;
            for (int j = 0; j < listSubAnswer.size(); j++) {
                or |= listSubAnswer.get(j);
            }
            if (or > maxOr) {
                maxOr = or;
                answer = 1;
            }
            else if (or == maxOr) {
                answer++;
            }
        }
        return answer;
    }
    private void findSubsets(List<List<Integer>> listAnswer, List<Integer> listSubAnswer, int[] nums, int index) {
        // base case.
        if (index == nums.length) {
            listAnswer.add(new ArrayList<>(listSubAnswer));
            return;
        }
        
        // include the element.
        listSubAnswer.add(nums[index]);
        findSubsets(listAnswer, listSubAnswer, nums, index + 1);
        
        // exclude the element.
        listSubAnswer.remove(listSubAnswer.size() - 1);
        findSubsets(listAnswer, listSubAnswer, nums, index + 1);
    }
}