class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int topRow = 0;
        int bottomRow = matrix.length - 1;
        int leftColumn = 0;
        int rightColumn = matrix[0].length - 1;
        int element = 0;
        List<Integer> listAnswer = new ArrayList<>();
        while (element < matrix.length * matrix[0].length) {
            // Visiting Top Row.
            for (int col = leftColumn; col <= rightColumn; col++) {
                listAnswer.add(matrix[topRow][col]);
                element++;
            }
            topRow++;
            // Visiting Right Column.
            for (int row = topRow; row <= bottomRow; row++) {
                listAnswer.add(matrix[row][rightColumn]);
                element++;
            }
            rightColumn--;
            // Visiting Bottom Row.
            for (int col = rightColumn; col >= leftColumn && bottomRow >= topRow; col--) {
                listAnswer.add(matrix[bottomRow][col]);
                element++;
            }
            bottomRow--;
            // Visiting Left Column;
            for (int row = bottomRow; row >= topRow && leftColumn <= rightColumn; row--) {
                listAnswer.add(matrix[row][leftColumn]);
                element++;
            }
            leftColumn++;
        }
        return listAnswer;
    }
}