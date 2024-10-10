class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (stack.empty() || currentChar == '(') {
                stack.push(currentChar);
            }
            else {
                if (stack.peek() == '(') {
                    stack.pop();
                }
                else {
                    stack.push(currentChar);
                }
            }
        }
        return stack.size();
    }
}