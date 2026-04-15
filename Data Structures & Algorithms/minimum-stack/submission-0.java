class MinStack {

    Deque<Integer> deque;
    Deque<Integer> snapshots; 

    public MinStack() {
        deque = new ArrayDeque<>();
        snapshots = new ArrayDeque<>();
    }
    
    public void push(int val) {
        deque.push(val);
        snapshots.push(Math.min(deque.getFirst(), snapshots.isEmpty() ? val : snapshots.getFirst()));
    }
    
    public void pop() {
        deque.pop();
        snapshots.pop();
    }
    
    public int top() {
        return deque.peek();
    }
    
    public int getMin() {
        return snapshots.peek();
    }
}
