class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Arrays.sort(points, (point1, point2) -> {
            int num1 = calcDistance(point1);
            int num2 = calcDistance(point2);
            if (num1 < num2) {
                return -1; 
            } 
            else if (num1 > num2) {
                return 1;
            }
            else {
                return 0;
            }
        });
        int[][] answerArray = new int[k][2];
        int index = 0;
        for (int i = 0; i < k; i++) {
            answerArray[index++] = points[i];
        }
        return answerArray;
    }
    private int calcDistance(int[] point) {
        long num1 = (point[1] * 1l) * point[1];
        long num2 = (point[0] * 1l) * point[0];
        return (int) (num1 + num2);
    }
}