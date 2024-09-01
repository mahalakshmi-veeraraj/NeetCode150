class Solution {
    int[] x = {0, 0, 1, -1};
    int[] y = {1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    numIslands++;
                    dfs(grid, row, col);            
                }
            }
        }
        return numIslands;
    }
    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        for (int i = 0; i < x.length; i++) {
            int r = row + x[i];
            int c = col + y[i];
            if (isValidCell(grid.length, grid[0].length, r, c) && grid[r][c] == '1') {
                dfs(grid, r, c);
            }
        }
    }
    private boolean isValidCell (int totalRow, int totalColumn, int row, int col) {
        
        return row < totalRow && row >= 0 && col < totalColumn && col >= 0;
    }
}