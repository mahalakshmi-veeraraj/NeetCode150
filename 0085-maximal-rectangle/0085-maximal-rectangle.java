class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        int maxArea = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    height[col]++;
                }
                else {
                    height[col] = 0;
                }
            }
            maxArea = Math.max(maxArea, maxAreaInHistogram(height));
        }
        return maxArea;
    }
    private int maxAreaInHistogram(int[] height) {
        int n = height.length;
        int[] smallerElementOnLeft = new int[n];
        int[] smallerElementOnRight = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            smallerElementOnLeft[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            smallerElementOnRight[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }
        int wh = 0;
        int ht = 0;
        int area = 0;
        int maxArea = 0;
        int maxElementIndexOnLeft = -1;
        int maxElementIndexOnRight = -1;
        for (int i = 0; i < n; i++) {
            ht = height[i];
            maxElementIndexOnLeft = smallerElementOnLeft[i] == -1 ? 0 : smallerElementOnLeft[i] + 1;
            maxElementIndexOnRight = smallerElementOnRight[i] == -1 ? n - 1 : smallerElementOnRight[i] - 1;
            wh = maxElementIndexOnRight - maxElementIndexOnLeft + 1;
            area = wh * ht;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}