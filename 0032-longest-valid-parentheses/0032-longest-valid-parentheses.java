// Monotonic stack with indices
public class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>(); // the stack represents: Indices that define the left boundary of a valid substring
        stack.push(-1); // sentinel. why?  =>  current_length = i - last_invalid_index, without it → messy edge cases.

        int maxLen = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    // New invalid base
                    stack.push(i);
                } else {
                    // Valid substring length
                    maxLen = Math.max(maxLen, i - stack.peek()); 
                }
                // At any index i (when we see ')' and it matches): length = i - stack.peek(); 
                // stack.peek() must represent the index BEFORE the start of the current valid substring, so a sentinel/invalid base is required
            }
        }
        return maxLen;
    }
}



/**

 */