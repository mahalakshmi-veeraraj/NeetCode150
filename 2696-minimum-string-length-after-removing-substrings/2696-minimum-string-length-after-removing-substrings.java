class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (stack.isEmpty() || currentChar != 'B' && currentChar != 'D') {
                stack.push(currentChar);
                continue;
            }
            if (currentChar == 'B') {
                if (stack.peek() == 'A') stack.pop();
                else stack.push(currentChar);
            }
            else if (currentChar == 'D') {
                if (stack.peek() == 'C') stack.pop();
                else stack.push(currentChar);
            }
        }
        return stack.size();
    }
}