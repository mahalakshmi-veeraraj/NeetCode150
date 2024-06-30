class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (e1, e2) -> e2[0] - e1[0]);
        int[] parentAlice = new int[n + 1];
        int[] parentBob = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parentAlice[i] = i;
            parentBob[i] = i;
        }
        int totalEdges = edges.length;
        int requiredEdges = 0;
        int aliceCount = 0;
        int bobCount = 0;
        for (int i = 0; i < edges.length; i++) {
            int type = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];
            int rootUAlice = find(u, parentAlice);
            int rootVAlice = find(v, parentAlice);
            int rootUBob = find(u, parentBob);
            int rootVBob = find(v, parentBob);
            if (type == 3) {
                if (rootUAlice != rootVAlice) {
                    union(u, v, parentAlice);
                    union(u, v, parentBob);
                    aliceCount++;
                    bobCount++;
                    requiredEdges++;
                }
            }
            else if (type == 2) {
                if (rootUBob != rootVBob) {
                    union(u, v, parentBob);
                    bobCount++;
                    requiredEdges++;
                }
            }
            else {
                if (rootUAlice != rootVAlice) {
                    union(u, v, parentAlice);
                    aliceCount++;
                    requiredEdges++;
                }
            }
        }
        return (bobCount == n - 1) && (aliceCount == n - 1) ? totalEdges - requiredEdges : -1;
    }
    private boolean union (int u, int v, int[] parent) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        if (rootU != rootV) {
            parent[rootU] = rootV;
        }
        return true;
    }
    private int find (int node, int[] parent) {
        if (parent[node] == node) return node;
        parent[node] = find(parent[node], parent);
        return parent[node];
    }
}