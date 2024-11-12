class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        int[] answerArray = new int[queries.length];
        int maxBeauty = 0;
        
        // Brute Force Approach: Time Complexity - O(N ^ Q)
        // for (int i = 0; i < queries.length; i++) {
        //     maxBeauty = 0;
        //     for (int j = 0; j < items.length; j++) {
        //         if (items[j][0] > queries[i]) break;
        //         maxBeauty = Math.max(maxBeauty, items[j][1]);
        //     }
        //     answerArray[i] = maxBeauty;
        // }
        
        // Optimal Approach: (Two pointers algorithm) Time Complexity - O(N + Q) 
        int i = 0;
        int j = 0;
        while (j < sortedQueries.length) {
            while (i < items.length && items[i][0] <= sortedQueries[j][0]) {
                maxBeauty = Math.max(maxBeauty, items[i][1]);
                i++;
            }
            answerArray[sortedQueries[j][1]] = maxBeauty;
            j++;
        }
        
        return answerArray;
    }
}