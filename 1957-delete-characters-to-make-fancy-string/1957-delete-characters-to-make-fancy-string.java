class Solution {
    public String makeFancyString(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        char currentChar = '\0';
        int frequencyCount = 0;
        for (int i = 0; i < n; i++) {
            currentChar = s.charAt(i);
            if (stack.empty() || stack.peek() == currentChar) {
                frequencyCount++;
            }
            else {
                frequencyCount = 1;
            }
            if (frequencyCount < 3) stack.add(currentChar);
        }
        StringBuilder answerStrBuilder = new StringBuilder();
        while (!stack.empty()) {
            answerStrBuilder.append(stack.pop());
        }
        return answerStrBuilder.reverse().toString();
    }
}