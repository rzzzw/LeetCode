class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.poll() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

/**
1. Clarity
    • The input is a string containing only parentheses characters ()[]{}.
    • I should return whether every opening bracket has a correctly matched closing bracket in the correct order.
    • Can I assume the input only contains these six characters?
    ...
2. Example
3. Initial intuition
    My first thought is that whenever I see a closing bracket, I need to know the most recent unmatched opening bracket.That "most recent" behavior sounds like a stack.

4. Explain the algorithm
    I'll scan from left to right.
    Every opening bracket goes onto the stack.
    When I encounter a closing bracket, it must match the current stack top.
    If the stack is empty or doesn't match, I can immediately return false.
    At the end, the stack must also be empty.

5. Dry run --> "{[]}"
6. Complexity
     Time O(n); Space O(n).
7. Code


 */