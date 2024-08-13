class Solution {
    public int[][] generateMatrix(int n) {
        int[][] spiralMatrix = new int[n][n];
        int element = 1;
        int topRow = 0;
        int bottomRow = n - 1;
        int leftColumn = 0;
        int rightColumn = n - 1;
        while (element <= n * n) {
            for (int col = leftColumn; col <= rightColumn; col++) {
                spiralMatrix[topRow][col] = element;
                element++;
            }
            topRow++;
            for (int row = topRow; row <= bottomRow; row++) {
                spiralMatrix[row][rightColumn] = element;
                element++;
            }
            rightColumn--;
            for (int col = rightColumn; col >= leftColumn; col--) {
                spiralMatrix[bottomRow][col] = element;
                element++;
            }
            bottomRow--;
            for (int row = bottomRow; row >= topRow; row--) {
                spiralMatrix[row][leftColumn] = element;
                element++;
            }
            leftColumn++;
        } 
        return spiralMatrix;
    }
}