class Solution {
    class Pair implements Comparable<Pair> {
        int index = -1;
        int value = 0;
        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
        @Override
        public int compareTo(Pair pair) {
            return pair.value - this.value;
        }
    }
    public long maximumImportance(int n, int[][] roads) {
        int[] arr = new int[n];
        int value = n;
        for (int row = 0; row < roads.length; row++) {
            arr[roads[row][0]]++;
            arr[roads[row][1]]++;
        }       
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            Pair pair = new Pair(i, arr[i]);
            maxHeap.add(pair);
        }
        while (!maxHeap.isEmpty()) {
            Pair peekPair = maxHeap.poll();
            arr[peekPair.index] = value;
            value--;
        }
        long answer = 0;
        long subAnswer = 0;
        for (int row = 0; row < roads.length; row++) {
            subAnswer = (1L * arr[roads[row][0]]) + arr[roads[row][1]]; 
            answer += subAnswer;
        }
        return answer;
    }
} 
