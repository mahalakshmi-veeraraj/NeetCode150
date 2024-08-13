class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAnswer = new ArrayList<>();
        List<Integer> listSubAnswer = new ArrayList<>();
        Arrays.sort(candidates);
        find(listAnswer, listSubAnswer, candidates, target, 0);
        return listAnswer;
    }
    private void find (List<List<Integer>> listAnswer, List<Integer> listSubAnswer, int[] candidates, int target, int index) {
        if (target == 0) {
            listAnswer.add(new ArrayList<>(listSubAnswer));
            return;
        }
        
        if (index >= candidates.length || candidates[index] > target) return;
        
        listSubAnswer.add(candidates[index]);
        find(listAnswer, listSubAnswer, candidates, target - candidates[index], index);
        
        listSubAnswer.remove(listSubAnswer.size() - 1);
        find(listAnswer, listSubAnswer, candidates, target, index + 1);
    }
}