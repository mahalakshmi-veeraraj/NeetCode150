class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftNS = new int[n]; // leftNS - Left nearest smaller.
        int[] rightNS = new int[n]; // rightNS - Right nearest smaller.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            
            leftNS[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }    
        
            rightNS[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }
        int width = 0;
        int height = 0;
        int area = 0;
        int maxArea = Integer.MIN_VALUE;
        int leftNSEI = -1; // leftNSEI - Left nearest smaller element index.
        int rightNSEI = -1; // rightNSEI - Right nearest smaller element index.
        for (int i = 0; i < n; i++) {
            leftNSEI = leftNS[i] == -1 ? 0 : leftNS[i] + 1;
            rightNSEI = rightNS[i] == -1 ? n - 1 : rightNS[i] - 1;
            height = heights[i];
            width = rightNSEI - leftNSEI + 1;
            area = width * height;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}