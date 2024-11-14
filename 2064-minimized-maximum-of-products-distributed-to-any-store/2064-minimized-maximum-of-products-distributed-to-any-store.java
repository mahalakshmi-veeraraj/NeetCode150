class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, quantities[i]);
        }
        int low = 1;
        int high = max;
        int middle = 0;
        int answer = max;
        while (low <= high) {
            middle = (low + high) / 2;
            if (isPossibleToDistribute(middle, n, quantities)) {
                high = middle - 1;
                answer = Math.min(answer, middle);
            }
            else {
                low = middle + 1;
            }
        }
        return answer;
    }
    private boolean isPossibleToDistribute (int number, int n, int[] quantities) {
        int currentlyDistributingProductType = 0;
        int currentlyDistributedProducts = 0;
        for (int i = 1; i <= n; i++) {
            currentlyDistributedProducts += number;
            if (currentlyDistributingProductType >= quantities.length) return true;
            if (currentlyDistributedProducts >= quantities[currentlyDistributingProductType]) {
                currentlyDistributingProductType++;
                currentlyDistributedProducts = 0;
            }
        }
        return currentlyDistributingProductType >= quantities.length;
    }
}