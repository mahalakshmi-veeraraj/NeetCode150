class MinStack {
    class Pair {
        int element;
        int minElement;
        public Pair (int element, int minElement) {
            this.element = element;
            this.minElement = minElement;
        }
    }
    Stack<Pair> stack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if (stack.empty()) {
            stack.push(new Pair(val, val));
        }
        else {
            stack.push(new Pair(val, Math.min(getMin(), val)));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        if (stack.empty()) return -1;
        
        return stack.peek().element;
    }
    
    public int getMin() {
        if (stack.empty()) return -1;
        
        return stack.peek().minElement;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */