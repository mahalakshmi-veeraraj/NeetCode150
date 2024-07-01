class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }
        int stone1 = 0;
        int stone2 = 0;
        while (!maxHeap.isEmpty()) {
            stone1 = maxHeap.poll();
            if (maxHeap.isEmpty()) return stone1;
            stone2 = maxHeap.poll();
            if (stone1 != stone2) {
                maxHeap.add(Math.abs(stone1 - stone2));
            }
        }
        return 0;
    }
}