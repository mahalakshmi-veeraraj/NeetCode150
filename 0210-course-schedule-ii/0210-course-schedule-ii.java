class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] answerArray = new int[numCourses];
        List<List<Integer>> listAdjacency =  new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            listAdjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            listAdjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            Integer peekNode = queue.poll();
            answerArray[index++] = peekNode;
            for (Integer neighBourNode : listAdjacency.get(peekNode)) {
                inDegree[neighBourNode]--;
                if (inDegree[neighBourNode] == 0) {
                    queue.add(neighBourNode);
                }
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0) {
                return new int[]{};
            }
        }
        return answerArray;
    }
}