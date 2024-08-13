class Solution {
    public void setZeroes(int[][] matrix) {
        int totalRow = matrix.length;
        int totalColumn = matrix[0].length;
        boolean blnRowHasZero = false;
        boolean blnColumnHasZero = false;
        for (int row = 0; row < totalRow; row++) {
            for (int col = 0; col < totalColumn; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0) blnRowHasZero = true;
                    if (col == 0) blnColumnHasZero = true;
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        for (int row = 1; row < totalRow; row++) {
            for (int col = 1; col < totalColumn; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        if (blnRowHasZero) {
            for (int col = 0; col < totalColumn; col++) {
                matrix[0][col] = 0;
            }
        }
        if (blnColumnHasZero) {
            for (int row = 0; row < totalRow; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}