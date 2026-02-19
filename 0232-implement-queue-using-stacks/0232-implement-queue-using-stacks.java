class MyQueue {

    // field/member variables, define the state of an object of the class:
    private Deque<Integer> inStack;  //  stores newly added elements (like an input buffer).
    private Deque<Integer> outStack;  //  stores elements ready to be removed (like an output buffer).

    // constructor:
    // A constructor is a special method that runs when you create a new object of the class
    // It initializes the object's state (in this case, it creates two empty stacks).
    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        moveIfNeeded();
        return outStack.pop();        
    }
    
    public int peek() {
        moveIfNeeded();
        return outStack.peek();        
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();       
    }

    private void moveIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }   
}

/*
Term	            Description
Constructor:	    Special method that is called once when an object is created. It sets up the initial state of the object. 
                    It has the same name as the class and no return type.

Instance Method:	Regular method that defines behavior for the object — you can call it multiple times on the object. 
                    It can have a return type (like Integer, void, etc.).

Solution q = new Solution(); // constructor is called
q.offer(10);                 // instance method called
q.poll();                    // instance method called
*/  

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */