class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        char peekChar = '\0';
        char currentChar = '\0';
        for (int i = 0; i < n; i++) {
            currentChar = s.charAt(i);
            if (stack.empty()) {
                stack.push(currentChar);
                continue;
            }
            peekChar = stack.peek();
            if (peekChar == '[' && currentChar == ']') {
                stack.pop();
            }
            else if (peekChar == '{' && currentChar == '}') {
                stack.pop();
            }
            else if (peekChar == '(' && currentChar == ')') {
                stack.pop();
            }
            else {
                stack.push(currentChar);
            }
        }
        return stack.empty();
    }
}