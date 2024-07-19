class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> listAnswer = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (isLuckyNum(matrix, row, col)) {
                    listAnswer.add(matrix[row][col]);
                }
            }
        }
        return listAnswer;
    }
    private boolean isLuckyNum(int[][] matrix, int row, int col) {
        int num = matrix[row][col];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, matrix[row][i]);
        }
        for (int i = 0; i < matrix.length; i++) {
            max = Math.max(max, matrix[i][col]);
        }
        return num == min && num == max;
    }
}