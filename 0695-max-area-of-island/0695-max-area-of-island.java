class Solution {
    class Answer {
        int result = 0;
        public Answer(int result) {
            this.result = result;
        }
    }
    int[] x = {0, 0, -1, 1};
    int[] y = {-1, 1, 0, 0};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    Answer answer = new Answer(0);
                    dfs(grid, r, c, answer);
                    //System.out.println("SubAnswer is "+ subAnswer);
                    maxArea = Math.max(maxArea, answer.result);
                }
            }
        }
        return maxArea;
    }
    private void dfs (int[][] grid, int r, int c, Answer answer) {
        grid[r][c] = 2;
        answer.result++;
        //System.out.println("SubAnswer value in DFS method "+answe.result);
        for (int i = 0; i < x.length; i++) {
            int r1 = x[i] + r;
            int c1 = y[i] + c;
            if (isValidRow(r1, c1, grid.length, grid[0].length) && grid[r1][c1] == 1) {
                dfs(grid, r1, c1, answer);
            }
        }
    }
    private boolean isValidRow (int r, int c, int row, int col) {
        if (r >= 0 && r < row && c >= 0 && c < col) {
            return true;
        }
        return false;
    }
}
