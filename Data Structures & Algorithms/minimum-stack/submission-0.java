class MinStack {
    Stack<Integer> main;
    Stack<Integer> min;

    public MinStack() {
        this.main = new Stack<>();
        this.min = new Stack<>();    
    }
    
    public void push(int val) {
        this.main.push(val);
        if (this.min.isEmpty() || min.peek() > val) min.push(val);
        else min.push(min.peek());
    }
    
    public void pop() {
        main.pop();
        min.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
