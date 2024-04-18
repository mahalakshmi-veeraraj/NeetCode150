class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        int middle = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            high = Math.max(high, piles[i]);
        }
        int answer = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            int totalTimeReq = getTotalTimeReq(piles, middle);
            if (totalTimeReq <= h) {
                answer = middle;
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return answer;
    }
    private int getTotalTimeReq(int[] piles, int bananasPerHour) {
        int totalTimeReq = 0;
        for (int i = 0; i < piles.length; i++) {
            totalTimeReq += Math.ceil((double)piles[i]/(double)bananasPerHour);
        }
        return totalTimeReq;
    }
}

// 3, 6, 7, 11
// low = 1 high = 11
// middle = 6

