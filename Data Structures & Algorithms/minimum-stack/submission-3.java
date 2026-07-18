class MinStack {

    private int[] stack;
    private int stackHead;
    private int[] minStack;
    private int minStackHead;

    public MinStack() {
        stack = new int[10000];
        stackHead = -1;
        minStack = new int[10000];
        minStackHead = -1;
    }
    
    public void push(int val) {
        if (minStackHead == -1 || val <= this.getMin()) {
            minStackHead++;
            minStack[minStackHead] = val;
        }
        stackHead++;
        stack[stackHead] = val;
    }
    
    public void pop() {
        if (minStackHead != -1 && this.top() == this.getMin()) {
            minStackHead--;
        }
        stackHead--;
    }
    
    public int top() {
        return stack[stackHead];
    }
    
    public int getMin() {
        return minStack[minStackHead];
    }
}
