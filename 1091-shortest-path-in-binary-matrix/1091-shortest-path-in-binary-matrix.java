class Solution {
int[] x = {0, 0, 1, -1, 1, 1, -1, -1};
	
int[] y = {-1, 1, 0, 0, -1, 1, -1, 1};

    class Pair implements Comparable<Pair> {
        int sourceNode;
        int desitnationNode;
        int cost;
        public Pair(int sourceNode, int desitnationNode, int cost) {
            this.sourceNode = sourceNode;
            this.desitnationNode = desitnationNode;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair pair) {

            return this.cost - pair.cost;
        }
    }
    public int shortestPathBinaryMatrix(int[][] A) {
        if (A[0][0] == 1 || A[A.length - 1][A.length - 1] == 1) return  -1;
        int[] B = {0, 0};
        int[] C = {A.length - 1, A[0].length - 1};
        int[][] distance = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(B[0], B[1], 1));
        distance[B[0]][B[1]] = 1;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.sourceNode;
            int col = pair.desitnationNode;
            if (row == C[0] && col == C[1]) return distance[row][col];
            for (int i = 0; i < x.length; i++) {
                int r = row + x[i];
                int c = col + y[i];
                if (isValidCell(r, c, A.length, A[0].length) && A[r][c] == 0) {
                    if (distance[r][c] > distance[row][col] + 1) {
                        distance[r][c] = distance[row][col] + 1;
                        queue.add(new Pair(r, c, distance[r][c]));
                    }
                }
            }
        }
        return distance[C[0]][C[1]] == Integer.MAX_VALUE ? -1 : distance[C[0]][C[1]];
    }
    
    private boolean isValidCell(int r, int c, int row, int col) {

        return r < row && r >= 0 && c < col && c >= 0;
    }
}