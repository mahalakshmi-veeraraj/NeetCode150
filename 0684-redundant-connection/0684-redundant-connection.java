class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(!unite(u, v, parent)) return edges[i];
        }
        return new int[]{-1, -1};
    }
    private int find_Root (int node, int[] parent) {
        if (parent[node] == node) return node;
        parent[node] = find_Root(parent[node], parent);
        return parent[node];
    }
    private boolean unite (int u, int v, int[] parent) {
        int rootU = find_Root(u, parent);
        int rootV = find_Root(v, parent);
        if (rootU != rootV) {
            parent[rootU] = rootV;
            return true;
        }    
        return false;
    }
}