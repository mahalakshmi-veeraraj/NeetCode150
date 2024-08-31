class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            if (stack.empty() || currChar == '{' || currChar == '[' || currChar == '(') {
                stack.push(currChar);
            } 
            else if (!stack.empty()) {
                char topChar = stack.pop();
                if (currChar == '}' && topChar != '{') return false;
                else if (currChar == ']' && topChar != '[') return false;
                else if (currChar == ')' && topChar != '(') return false;
            }
        }
        return stack.empty();
    }
}