class Solution {
    class Pair implements Comparable<Pair> {
        int node;
        int time;
        public Pair (int node, int time) {
            this.node = node;
            this.time = time;
        }
        @Override
        public int compareTo (Pair pair) {
            
            return this.time - pair.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n + 1];
        List<List<Pair>> listAdjacency = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
            listAdjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int fromNode = times[i][0];
            int toNode = times[i][1];
            int time = times[i][2];
            listAdjacency.get(fromNode).add(new Pair(toNode, time));
        }
        Queue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(k, 0));
        distance[k] = 0;
        while (!queue.isEmpty()) {
            Pair peek = queue.poll();
            for (Pair neighbour : listAdjacency.get(peek.node)) {
                if (neighbour.time + peek.time < distance[neighbour.node]) {
                    distance[neighbour.node] = neighbour.time + peek.time;
                    queue.add(new Pair(neighbour.node, neighbour.time + peek.time));
                }
            }
        }
        int answer = 0;
        for (int i = 1; i < distance.length; i++) {
            answer = Math.max(distance[i], answer);
        }   
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}