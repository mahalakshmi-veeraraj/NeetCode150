class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] next_Smaller_Element_On_Left = new int[n];
        int[] next_Smaller_Element_On_Right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            next_Smaller_Element_On_Right[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            next_Smaller_Element_On_Left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        int area = 0;
        int width = 0;
        int height = 0;
        int maxArea = 0;
        int greaterElementOnLeft = 0;
        int greaterElementOnRight = 0;
        
        for (int i = 0; i < n; i++) {
            height = heights[i];
            
            greaterElementOnLeft = next_Smaller_Element_On_Left[i] == -1 ? 0 : next_Smaller_Element_On_Left[i] + 1;
            greaterElementOnRight = next_Smaller_Element_On_Right[i] == -1 ? n - 1 : next_Smaller_Element_On_Right[i] - 1;
            
            width = greaterElementOnRight - greaterElementOnLeft + 1;
            
            area = width * height;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}