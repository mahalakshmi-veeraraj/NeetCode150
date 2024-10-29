class Solution {
    private int[][] directions = {{0, 1}, {1, 1}, {-1, 1}};
    private int finalAnswer = 0;
    public int maxMoves(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            initializeDPArray(dp);
            find (grid, i, 0, 0, dp);
        }
        return finalAnswer;
    }
    private void initializeDPArray(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
    }
    private void find (int[][] grid, int row, int col, int currentMoves, int[][] dp) {
        int maxMoves = Integer.MIN_VALUE;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValidCell(newRow, newCol, grid.length, grid[0].length) && grid[newRow][newCol] > grid[row][col]) {
                if (dp[newRow][newCol] == -1) {
                    find(grid, newRow, newCol, currentMoves + 1, dp);
                    maxMoves = Math.max(maxMoves, currentMoves + 1);
                }
            }
        }
        dp[row][col] = maxMoves;
        finalAnswer = Math.max(finalAnswer, maxMoves);
    }
    private boolean isValidCell (int r, int c, int row, int col) {
        
        return r >= 0 && r < row && c >= 0 && c < col;
    }
}