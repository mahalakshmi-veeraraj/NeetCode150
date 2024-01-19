class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> hashSet = new HashSet<>();
        // Row wise checking the board.
        for (int row = 0; row < 9; row++) {
            hashSet = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;
                if (hashSet.contains(board[row][col])) {
                    return false;
                }
                hashSet.add(board[row][col]);
            }
        }
        // Column wise checking the board.
        for (int col = 0; col < 9; col++) {
            hashSet = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.') continue;
                if (hashSet.contains(board[row][col])) {
                    return false;
                }
                hashSet.add(board[row][col]);
            }
        }
        // Sub-boxes wise checking the board.
        for (int startRow = 0; startRow < 9; startRow += 3) {
            int endRow = startRow + 2;
            for (int startCol = 0; startCol < 9; startCol += 3) {
                int endCol = startCol + 2;
                if (!check(board, startRow, endRow, startCol, endCol)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean check (char[][] board, int startRow, int endRow, int startCol, int endCol) {
        Set<Character> hashSet = new HashSet<>();
        for (int r = startRow; r <= endRow; r++) {
            for (int c = startCol; c <= endCol; c++) {
                if (board[r][c] == '.') continue;
                if (hashSet.contains(board[r][c])) return false;
                hashSet.add(board[r][c]);
            }
        }
        return true;
    }
}