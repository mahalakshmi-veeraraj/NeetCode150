class Solution {
    class Pair implements Comparable<Pair>{
        int idleTime;
        int count;
        public Pair(int idleTime, int count) {
            this.idleTime = idleTime;
            this.count = count;
        }
        @Override
        public int compareTo(Pair pair) {
            return this.idleTime - pair.idleTime;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] frequencyArray = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            frequencyArray[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] != 0) {
                maxHeap.add(frequencyArray[i]);
            }
        }
        Deque<Pair> deque = new ArrayDeque<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !deque.isEmpty()) {
            time += 1;
            if (!maxHeap.isEmpty()) {
                Integer peekValue = maxHeap.poll();
                if (peekValue > 1) {
                    deque.addLast(new Pair(time + n, peekValue - 1));
                }
            }
            if (!deque.isEmpty() && deque.peekFirst().idleTime == time) {
                maxHeap.add(deque.peekFirst().count);
                deque.pollFirst();
            }
        }
        return time;
    }
}