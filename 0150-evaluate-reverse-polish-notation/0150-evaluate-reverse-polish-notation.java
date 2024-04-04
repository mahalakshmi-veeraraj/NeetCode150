class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            if (isOperator(tokens[i])) {
                int element2 = Integer.valueOf(stack.pop());
                int element1 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(getResult(tokens[i], element1, element2)));
            }   
            else {
                stack.push(tokens[i]);
            }
        }
        return Integer.valueOf(stack.peek());
    }
    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
    private int getResult(String operator, int element1, int element2) {
        switch(operator) {
            case "+": return element1 + element2;
            case "-": return element1 - element2;
            case "*": return element1 * element2;
            case "/": return element1 / element2;
        }
        return 0;
    }
}
