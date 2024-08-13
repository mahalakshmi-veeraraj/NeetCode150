class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int middle = 0;
        int searchRow = -1;
        while (low <= high) {
            middle = (low + high) / 2;
            if (matrix[middle][0] <= target) {
                searchRow = middle;
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        if (searchRow == -1) return false;
        low = 0;
        high = matrix[0].length - 1;
        while (low <= high) {
            middle = (low + high) / 2;
            if (matrix[searchRow][middle] == target) return true;
            else if (matrix[searchRow][middle] < target) low = middle + 1;
            else high = middle - 1;
        }
        return false;
    }
}


 