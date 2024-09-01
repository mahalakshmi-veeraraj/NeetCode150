class Solution {
    public int minReorder(int n, int[][] connections) {
        int[] visited = new int[n];
        List<List<Integer>> listAdjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listAdjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            listAdjacency.get(connections[i][0]).add(connections[i][1]);
            listAdjacency.get(connections[i][1]).add(-connections[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int queueSize = 0;
        queue.add(0);
        int answer = 0;
        while (!queue.isEmpty()) {
            queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Integer peekValue = queue.poll();
                visited[peekValue] = 1;
                for (Integer neighBourNode : listAdjacency.get(peekValue)) {
                    if (visited[Math.abs(neighBourNode)] == 1) continue;
                    if (neighBourNode > 0) answer++;
                    queue.add(Math.abs(neighBourNode));
                }
            }
        }
        return answer;
    }
}