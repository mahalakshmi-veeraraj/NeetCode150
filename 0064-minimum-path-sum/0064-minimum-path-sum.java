class Solution {
    public int minPathSum(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int[][] dpGrid = new int[totalRows][totalCols];
        
        return recursion(grid, dpGrid, 0, 0);
    }
    private int recursion (int[][] grid, int[][] dpGrid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length) return Integer.MAX_VALUE;
        else if (row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];
        if (dpGrid[row][col] != 0) return dpGrid[row][col];
        
        int right = recursion(grid, dpGrid, row, col + 1); // right side movement.
        int down = recursion(grid, dpGrid, row + 1, col); // down side movement.
        dpGrid[row][col] = Math.min(down , right) + grid[row][col];
        return dpGrid[row][col];
    }
}