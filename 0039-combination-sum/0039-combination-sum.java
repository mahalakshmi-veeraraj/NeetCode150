class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAnswer = new ArrayList<>();
        find(listAnswer, new ArrayList<>(), candidates, target, 0);
        return listAnswer;
    }
    private void find (List<List<Integer>> listAnswer, List<Integer> listSubAnswer, int[] candidates, int target, int index) {
        if (target == 0) {
            listAnswer.add(new ArrayList<>(listSubAnswer));
            return;
        }
        else if (index >= candidates.length) {
            return;
        }
        
        // include element.
        listSubAnswer.add(candidates[index]);
        if (candidates[index] <= target)
            find(listAnswer, listSubAnswer, candidates, target - candidates[index], index);
        
        // exclude element.
        listSubAnswer.remove(listSubAnswer.size() - 1);
        find(listAnswer, listSubAnswer, candidates, target, index + 1);
    }
}