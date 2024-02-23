class Solution {
    class Pair {
        int row;
        int col;
        int level;
        public Pair(int level, int row, int col) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }
    int[] x = {0,0,-1,1};
    int[] y = {-1,1,0,0};
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new Pair(0, r, c));
                }
            }
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            Pair peekPair = queue.poll();
            answer = Math.max(answer, peekPair.level);
            for (int i = 0; i < x.length; i++) {
                int r1 = x[i] + peekPair.row;
                int c1 = y[i] + peekPair.col;
                if (isValidRow(r1, c1, row, col) && grid[r1][c1] == 1) {
                    grid[r1][c1] = 2;
                    queue.add(new Pair(peekPair.level + 1, r1, c1));
                }
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }
        return answer;
    }
    private boolean isValidRow(int r, int c, int row, int col) {
        if (r >= 0 && r < row && c >= 0 && c < col) {
            return true;
        }
        return false;
    }
}

