// /**
// Two Stacks
// Time: O(1) for all operations
// Space: O(n)
//  */

class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();
    int min = Integer.MAX_VALUE;

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() || minStack.peek() > value) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}




/**
One Stack(Space-Optimized)

 */
// class MinStack {
//     private Deque<Integer> stack;
//     private int min;

//     public MinStack() {
//         stack = new ArrayDeque<>();
//     }

//     public void push(int val) {
//         if (stack.isEmpty()) {
//             stack.offerFirst(val);
//             min = val;
//         } else {
//             if (val <= min) {
//                 stack.offerFirst(min);
//                 min = val;
//             }
//             stack.offerFirst(val);
//         }
//     }

//     public void pop() {
//         if (stack.isEmpty()) return;
//         if (stack.pollFirst() == min) {
//             if (!stack.isEmpty()) {
//                 min = stack.pollFirst();                
//             }
//         }
//     }

//     public int top(){
//         return stack.peek();
//     }

//     public int getMin() {
//         return min;
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

