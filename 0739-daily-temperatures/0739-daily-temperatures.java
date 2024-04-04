class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            nge[i] = stack.empty() ? 0 : stack.peek();
            stack.push(i);
        }
        int[] result = new int[n];
        for (int i = 0; i < nge.length; i++) {
            result[i] = nge[i] == 0 ? 0 : nge[i] - i;
        }
        return result;
    }
}