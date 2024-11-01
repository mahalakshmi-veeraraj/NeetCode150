class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAnswer = new ArrayList<>();
        List<Integer> listSubAnswer = new ArrayList<>();
        find (listAnswer, listSubAnswer, 0, target, candidates);
        return listAnswer;
    }
    private void find (List<List<Integer>> listAnswer, List<Integer> listSubAnswer, int index, int target, int[] candidates) {
        if (target == 0) {
            listAnswer.add(new ArrayList<>(listSubAnswer));
            return;
        }
        if (index >= candidates.length) return;
        
        // take element.
        int take = -1;
        if (candidates[index] <= target) {
            listSubAnswer.add(candidates[index]);
            find (listAnswer, listSubAnswer, index, target - candidates[index], candidates);
            take = 1; //marking helps to identify whether the element was taken earlier or not in the future.
        }
        
        // not take element.
        if (take != -1) listSubAnswer.remove(listSubAnswer.size() - 1);
        find (listAnswer, listSubAnswer, index + 1, target, candidates);
    }
}