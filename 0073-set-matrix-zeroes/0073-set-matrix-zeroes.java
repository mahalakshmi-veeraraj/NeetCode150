class Solution {
    public void setZeroes(int[][] matrix) {
        int totalRow = matrix.length;
        int totalColumn = matrix[0].length;
        int[] rowArr = new int[totalRow];
        int[] colArr = new int[totalColumn];
        for (int row = 0; row < totalRow; row++) {
            for (int col = 0; col < totalColumn; col++) {
                if (matrix[row][col] == 0) {
                    rowArr[row] = 1;
                    colArr[col] = 1;
                }
            }
        }
        for (int i = 0; i < rowArr.length; i++) {
            if (rowArr[i] == 0) continue;
            for (int col = 0; col < totalColumn; col++) {
                matrix[i][col] = 0;
            }
        }
        for (int i = 0; i < colArr.length; i++) {
            if (colArr[i] == 0) continue;
            for (int row = 0; row < totalRow; row++) {
                matrix[row][i] = 0;
            }
        }
    }
}