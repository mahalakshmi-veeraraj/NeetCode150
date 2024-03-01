class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                chessBoard[row][col] = '.';
            }
        }
        List<List<String>> listAnswer = new ArrayList<>();
        backTrack(n, 0, listAnswer, chessBoard);
        return listAnswer;
    }
    private void backTrack (int n, int col, List<List<String>> listAnswer, char[][] chessBoard) {
        if (col == n) {
            listAnswer.add(convertArrayToList(chessBoard));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (canPlaceQueen(row, col, chessBoard)) {
                chessBoard[row][col] = 'Q';
                backTrack(n, col + 1, listAnswer, chessBoard);
                chessBoard[row][col] = '.';
            }
        }
    }
    private boolean canPlaceQueen (int row, int col, char[][] chessBoard) {
        // Horizontal checking.
        for (int c = 0; c < col; c++) {
            if (chessBoard[row][c] == 'Q') return false;
        }
        
        // Vertical checking.
        for (int r = 0; r < row; r++) {
            if (chessBoard[r][col] == 'Q') return false;
        }
        
        // Upper Diagonal checking.
        int dupRow = row - 1;
        int dupCol = col - 1;
        while (dupRow >= 0 && dupCol >= 0) {
            if (chessBoard[dupRow][dupCol] == 'Q') return false;
            
            dupRow--;
            dupCol--;
        }
        
        // Lower Diagnoal checking.
        dupRow = row + 1;
        dupCol = col - 1;
        while (dupRow < chessBoard.length && dupCol >= 0) {
            if (chessBoard[dupRow][dupCol] == 'Q') return false;
            
            dupRow++;
            dupCol--;
        }
        return true;
    }
    private List<String> convertArrayToList (char[][] chessBoard) {
        List<String> listSubAnswer = new ArrayList<>();
        for (int row = 0; row < chessBoard.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < chessBoard[0].length; col++) {
                sb.append(chessBoard[row][col]);
            }
            listSubAnswer.add(sb.toString());
        }
        return listSubAnswer;
    }
}