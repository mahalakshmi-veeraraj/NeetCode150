class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int totalRows = rowSum.length;
        int totalColumns = colSum.length;
        int[][] restoreMatrix = new int[totalRows][totalColumns];
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalColumns; col++) {
                int val = Math.min(rowSum[row], colSum[col]);
                restoreMatrix[row][col] = val;
                rowSum[row] -= val;
                colSum[col] -= val;
            }
        }
        return restoreMatrix;
    }
}