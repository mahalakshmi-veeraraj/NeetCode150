class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.add(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            
            nge[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.add(i);
        }
        for (int i = 0; i < nge.length; i++) {
            if (nge[i] == 0) continue;
            answer[i] = nge[i] - i;
        }
        return answer;
    }
    public int[] bruteForce (int[] temperatures) { // Got Time Limit Exceeded Error by this Brute Force approach.
        int n = temperatures.length;
        int[] answer = new int[n];
        int numberOfDays = 0;
        boolean isFound = false;
        for (int i = 0; i < n; i++) {
            numberOfDays = 0;
            isFound = false;
            for (int j = i + 1; j < n; j++) {
                numberOfDays++;
                if (temperatures[j] > temperatures[i]) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) numberOfDays = 0;
            answer[i] = numberOfDays;
        }
        return answer;
    }
}


//   0  1  2  3  4  5  6  7
// [73,74,75,71,69,72,76,73]
// [74,75,76,72,72,76,0,0]
// [0, 1, 2, 3, 4, 5, 6, 7]
// [1, 2, 6, 5, 5, 6, 0, 0]
// [1, 1, 4, 2, 1, 1, 0, 0]