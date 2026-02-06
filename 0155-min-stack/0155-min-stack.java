// /**
// Two Stacks
// Time: O(1) for all operations
// Space: O(n)
//  */
// class MinStack {
//     private Deque<Integer> stack;
//     private Deque<Integer> minStack;

//     public MinStack() {
//         stack = new ArrayDeque<>();
//         minStack = new ArrayDeque<>();
//     }
    
//     public void push(int val) {
//         stack.offerFirst(val);
//         if (minStack.isEmpty()) {
//             minStack.offerFirst(val);
//         } else {
//             minStack.offerFirst(Math.min(val, minStack.peek()));
//         }
        
//     }
    
//     public void pop() {
//         stack.pollFirst();
//         minStack.pollFirst();
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return minStack.peek();
//     }
// }

/**
One Stack(Space-Optimized)

 */
class MinStack {
    private Deque<Integer> stack;
    private int min;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.offerFirst(val);
            min = val;
        } else {
            if (val <= min) {
                stack.offerFirst(min);
                min = val;
            }
            stack.offerFirst(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        if (stack.pollFirst() == min) {
            if (!stack.isEmpty()) {
                min = stack.pollFirst();                
            }
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin() {
        return min;
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

