// // Monotonic stack with indices
// public class Solution {
//     public int longestValidParentheses(String s) {
//         Deque<Integer> stack = new ArrayDeque<>(); // the stack represents: Indices that define the left boundary of a valid substring
//         stack.push(-1); // sentinel. why?  =>  current_length = i - last_invalid_index, without it → messy edge cases.

//         int maxLen = 0;

//         for(int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);

//             if (c == '(') {
//                 stack.push(i);
//             } else {
//                 stack.pop();

//                 if (stack.isEmpty()) {
//                     // New invalid base
//                     stack.push(i);
//                 } else {
//                     // Valid substring length
//                     maxLen = Math.max(maxLen, i - stack.peek()); 
//                 }
//                 // At any index i (when we see ')' and it matches): length = i - stack.peek(); 
//                 // stack.peek() must represent the index BEFORE the start of the current valid substring, so a sentinel/invalid base is required
//             }
//         }
//         return maxLen;
//     }
// }

// DP
/**
DP State: dp[i] = length of the longest valid parentheses substring that ends exactly at index i
          Ends at i means s[i] must be ')'.

A valid substring cannot end with '('. So: if (s.charAt(i) == '(') dp[i] = 0;

 */

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxLen = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {

                // case 1: "()"
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i > 2 ? dp[i - 2] : 0);
                }

                // case 2: "...))"
                else {
                    int prevLen = dp[i - 1];
                    int openIndex = i - prevLen - 1;

                    if (openIndex >= 0 && s.charAt(openIndex) == '(') {
                        dp[i] = prevLen + 2 + (openIndex >= 1 ? dp[openIndex - 1] : 0);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}
/**
dp[i]: 以i结尾的最长valid parentheses长度
遍历时，只要遇到左括号‘（’，一定不是结尾括号，所以不需要计算，保持为0；只有遇到右括号‘）’才计算

idx     0 1 2 3 4 5 6 7
s       ( ) ) ( ( ( ) )
dp      0 2 0 0 0 0 2 4

idx     0 1 2 3 4 5 
s       ( ) ( ( ) )  
dp      0 2 0 0 2 6
 */
