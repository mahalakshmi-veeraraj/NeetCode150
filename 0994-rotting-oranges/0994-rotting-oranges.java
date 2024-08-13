class Solution {
    class Pair {
        int row;
        int col;
        int level;
        public Pair(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }
    public int orangesRotting(int[][] grid) {
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        Queue<Pair> queue = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new Pair(row, col, 0));
                }
            }
        }
        int queueSize = 0;
        int answer = 0;
        while (!queue.isEmpty()) {
            queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Pair peek = queue.poll();
                answer = peek.level;
                for (int j = 0; j < x.length; j++) {
                    int r = peek.row + x[j];
                    int c = peek.col + y[j];
                    if (isValid(r, c, grid.length, grid[0].length) && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.add(new Pair(r, c, peek.level + 1));
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return answer;
    }
    private boolean isValid(int r, int c, int row, int col) {
        
        return r >= 0 && r < row && c >= 0 && c < col; 
    }
}