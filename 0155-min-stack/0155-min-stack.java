class MinStack {
    Stack<Pair> stack = new Stack<>();
    class Pair {
        private int minElement;
        private int element;
        public Pair (int minElement, int element) {
            this.minElement = minElement;
            this.element = element;
        }
        public int getMinElement() {
            return this.minElement;
        }
        public int getElement() {
            return this.element;
        }
    }
    public MinStack() {
        
    }
    
    public void push(int val) {
        if (stack.empty()) {
            stack.push(new Pair(val, val));
        }
        else {
            stack.push(new Pair(Math.min(val, getMin()), val));
        }
    }
    
    public void pop() {
        if (stack.empty()) return;
        
        stack.pop();
    }
    
    public int top() {
        
        return stack.empty() ? -1 : stack.peek().getElement();
    }
    
    public int getMin() {
        
        return stack.empty() ? -1 : stack.peek().getMinElement();
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