class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> subDp = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                subDp.add(-1);
            }
            dp.add(subDp);
        }
        return findMinSumPath(0, 0, dp, triangle);
    }
    private int findMinSumPath (int row, int col, List<List<Integer>> dp, List<List<Integer>> triangle) {
        if (row >= triangle.size() || col >= triangle.get(row).size()) return 0;
        if (row == triangle.size() - 1 && col < triangle.get(row).size()) return triangle.get(row).get(col);
        if (dp.get(row).get(col) != -1) return dp.get(row).get(col);
        
        int nextRowIthIndex = findMinSumPath(row + 1, col, dp, triangle);
        int nextRowIPlusOnethIndex = findMinSumPath(row + 1, col + 1, dp, triangle);
        int result = Math.min(nextRowIthIndex, nextRowIPlusOnethIndex) + triangle.get(row).get(col);
        dp.get(row).set(col, result);
        return dp.get(row).get(col);
    }
}