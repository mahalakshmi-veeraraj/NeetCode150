class Solution {
    class Pair implements Comparable<Pair> {
        int idleTime;
        int count;
        public Pair(int count, int idleTime) {
            this.count = count;
            this.idleTime = idleTime;
        }
        @Override
        public int compareTo(Pair pair) {
            return this.idleTime - pair.idleTime;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freqArray = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freqArray[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < freqArray.length; i++) {
            if (freqArray[i] == 0) continue;
            maxHeap.add(freqArray[i]);
        }
        int time = 0;
        Deque<Pair> deque = new ArrayDeque<>();
        while (!maxHeap.isEmpty() || !deque.isEmpty()){
            time += 1;
            if (!maxHeap.isEmpty()) {
                Integer peekVal = maxHeap.poll();
                if (peekVal > 1)
                    deque.addLast(new Pair(peekVal - 1, time + n));
            }
            if (!deque.isEmpty() && deque.peekFirst().idleTime == time) {
                Pair peekFirstPair = deque.pollFirst();
                maxHeap.add(peekFirstPair.count);
            }
        }
        return time;
    }
}