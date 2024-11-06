class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        int n = intervals.length;
        int answer = 0;
        int endInterval = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= endInterval) {
                endInterval = intervals[i][1];
            }
            else {
                answer++;
            }
        }
        return answer;
    }
}