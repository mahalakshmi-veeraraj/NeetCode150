class Solution {
    public int countSquares(int[][] matrix) {
        int totalRow = matrix.length;
        int totalColumn = matrix[0].length;
        if (totalRow == 0) return 0;
        
        int answer = 0;
        for (int row = 0; row < totalRow; row++) {
            for (int col = 0; col < totalColumn; col++) {
                if (matrix[row][col] == 0) continue;
                if (row >= 1 && col >= 1) {
                    matrix[row][col] = 1 + Math.min(matrix[row][col - 1], Math.min(matrix[row - 1][col], matrix[row - 1][col - 1]));
                }
                answer += matrix[row][col];
            }
        }
        return answer;
    }
}