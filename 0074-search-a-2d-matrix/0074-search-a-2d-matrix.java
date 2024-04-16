class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;
        int low = 0;
        int high = totalRows - 1;
        int middle = 0;
        int rowIndex = -1;
        while (low <= high) {
            middle = (low + high) / 2;
            if (matrix[middle][0] > target) {
                high = middle - 1;
            }
            else {
                rowIndex = middle;
                low = middle + 1;
            }
        }
        if (rowIndex == -1) return false;
        low = 0;
        high = totalColumns - 1;
        while (low <= high) {
            middle = (low + high) / 2;
            if (matrix[rowIndex][middle] == target) {
                return true;
            }
            else if (matrix[rowIndex][middle] < target) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return false;
    }
}

// low  = 0
// high = 2
// middle = 1

// matrix[middle][0] > target high = middle - 1

// low = 0
// high = 0
// middle = 0

// matrix[middle][0] < target low = middle + 1

// low = 1
// high = 0

