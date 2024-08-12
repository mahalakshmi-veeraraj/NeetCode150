class Solution {
    public int findCircleNum(int[][] isConnected) {
        int totalNumberOfRow = isConnected.length;
        int totalNumberOfColumn = isConnected[0].length;
        int[] visited = new int[totalNumberOfRow + 1];
        List<List<Integer>> listAdjacency = new ArrayList<>();
        for (int i = 0; i <= totalNumberOfRow; i++) listAdjacency.add(new ArrayList<>());
        for (int row = 0; row < totalNumberOfRow; row++) {
            for (int col = 0; col < totalNumberOfColumn; col++) {
                if (isConnected[row][col] == 0) continue;
                listAdjacency.get(row + 1).add(col + 1);
                listAdjacency.get(col + 1).add(row + 1);
            }
        }
        int numberOfProvinces = 0;
        for (int  i = 1; i <= totalNumberOfRow; i++) {
            if (visited[i] == 0) numberOfProvinces++;
            dfs(visited, listAdjacency, i);
        }
        return numberOfProvinces;
    }
    private void dfs(int[] visited, List<List<Integer>> listAdjacency, int node) {
        visited[node] = 1;
        for (Integer neighBour : listAdjacency.get(node)) {
            if (visited[neighBour] == 1) continue;
            dfs(visited, listAdjacency, neighBour);
        }
    }
}