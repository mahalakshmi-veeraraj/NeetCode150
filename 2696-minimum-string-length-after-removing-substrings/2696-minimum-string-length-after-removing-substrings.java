class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            }
            else {
                if (stack.peek() == 'A' && s.charAt(i) == 'B') {
                    stack.pop();
                }
                else if (stack.peek() == 'C' && s.charAt(i) == 'D') {
                    stack.pop();
                }
                else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.size();
    }
}