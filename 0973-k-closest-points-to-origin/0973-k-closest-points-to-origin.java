class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (e1, e2)->{
            int distance1 = distance(e1[0], e1[1]);
            int distance2 = distance(e2[0], e2[1]);
            return distance1 - distance2;
        });
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            answer[i][0] = points[i][0];
            answer[i][1] = points[i][1];
        }
        return answer;
    }
    private int distance(int x1, int y1) {
        int num1 = x1 * x1;
        int num2 = y1 * y1;
        return num1 + num2;
    }
}


// The distance between two points on the X-Y plane is the Euclidean distance 
// Math.sqrt((x1 - x2)^2 + (y1 - y2)^2)