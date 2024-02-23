class Solution {
    class Pair {
        int node;
        int parent;
        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] parent = new int[numCourses];
        
        List<List<Integer>> listAdjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            parent[i] = -1;
            listAdjacency.add(new ArrayList<>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            listAdjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(new Pair(i, 0));
            }
        }
        
        if (queue.isEmpty()) return false;
        
        while (!queue.isEmpty()) {
            Pair peekPair = queue.poll();
            parent[peekPair.node] = peekPair.parent;
            for (Integer neighBourNode : listAdjacency.get(peekPair.node)) {
                inDegree[neighBourNode]--;
                if (inDegree[neighBourNode] == 0) {
                    queue.add(new Pair(neighBourNode, peekPair.parent));
                }
            }    
        }
        
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != parent[0]) {
                return false;
            }
        }
        
        return true;
    }
}