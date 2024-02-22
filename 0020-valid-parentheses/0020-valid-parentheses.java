class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char ch = '\0';
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            }
            else {
                if (ch == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else if (ch == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                else if (ch == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else if (ch == ')' && stack.peek() != '(') {
                    return false;
                }
                else if (ch == '}' && stack.peek() != '{') {
                    return false;
                }
                else if (ch == ']' && stack.peek() != '[') {
                    return false;
                }
                else {
                    stack.push(ch);   
                }
            }
        }
        return stack.empty();
    }
}