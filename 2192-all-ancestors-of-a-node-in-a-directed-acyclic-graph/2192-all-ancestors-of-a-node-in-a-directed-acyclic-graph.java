class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] noOfParents = new int[n];
        Map<Integer, List<Integer>> parentToChild = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            noOfParents[edges[i][1]]++;
            if (!parentToChild.containsKey(edges[i][0])) {
                parentToChild.put(edges[i][0], new ArrayList<>());
            }
            parentToChild.get(edges[i][0]).add(edges[i][1]);
        }
        List<Set<Integer>> childToParents = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            childToParents.add(new TreeSet<>());
            if (noOfParents[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int currentParent = queue.poll();
            for (Integer child : parentToChild.getOrDefault(currentParent, new ArrayList<>())) {
                childToParents.get(child).add(currentParent);
                childToParents.get(child).addAll(childToParents.get(currentParent));
                noOfParents[child]--;
                if (noOfParents[child] == 0) {
                    queue.add(child);
                }
            }
        }
        List<List<Integer>> listAnswer = new ArrayList<>();
        for (Set<Integer> parents : childToParents) {
            listAnswer.add(new ArrayList<>(parents));
        }
        return listAnswer;
     }
}