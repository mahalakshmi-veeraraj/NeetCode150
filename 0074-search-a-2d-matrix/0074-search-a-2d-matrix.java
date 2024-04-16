class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;
        int low = 0;
        int high = totalRows - 1;
        int middle = 0;
        int answerRowIndex = -1;
        while (low <= high) {
            middle = (low + high) / 2;
            if (matrix[middle][0] > target) {
                high = middle - 1;
            }
            else {
                answerRowIndex = middle;
                low = middle + 1;
            }
        }
        if (answerRowIndex == -1) return false;
        low = 0;
        high = totalColumns - 1;
        while (low <= high) {
            middle = (low + high) / 2;
            if (matrix[answerRowIndex][middle] == target) {
                return true;
            }
            else if (matrix[answerRowIndex][middle] < target) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return false;
    }
}

