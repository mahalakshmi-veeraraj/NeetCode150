class MedianFinder {
    // Brute Force Approach.
    // List<Integer> listElement = new ArrayList<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        // Brute Force Approach.
        // listElement.add(num);
        if (minHeap.isEmpty() && maxHeap.isEmpty()) maxHeap.add(num);
        else {
            if (num < maxHeap.peek()) {
                maxHeap.add(num);
            }
            else {
                minHeap.add(num);
            }
        }
        if (Math.abs(minHeap.size() - maxHeap.size()) <= 1) return;
        if (minHeap.size() > maxHeap.size()) {
            int val = minHeap.poll();
            maxHeap.add(val);
        }
        else {
            int val = maxHeap.poll();
            minHeap.add(val);
        }
    }
    
    public double findMedian() {
        // Brute Force Approach.
        // Collections.sort(listElement);
        // int n = listElement.size();
        // if (n % 2 != 0) return listElement.get(n / 2);
        // return (double) (listElement.get(n / 2) + listElement.get((n / 2) - 1) ) / 2;
        
        if (minHeap.size() > maxHeap.size()) return minHeap.peek();
        else if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        else return (double)(minHeap.peek() + maxHeap.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */