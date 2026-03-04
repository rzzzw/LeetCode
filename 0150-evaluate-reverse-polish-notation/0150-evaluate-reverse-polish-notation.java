class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.length() == 1 && "+-*/".contains(token)) {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}



// class Solution {
//     public int evalRPN(String[] tokens) {
//         if (tokens == null || tokens.length == 0) {
//             return 0;
//         }
//         Deque<Integer> stack = new ArrayDeque<>();
//         for (String token : tokens) {
//             if (isOperator(token)) {
//                 int b = stack.poll();
//                 int a = stack.poll();
//                 int res = 0;

//                 switch (token) {
//                     case "+":
//                         res = a + b;
//                         break;
//                     case "-":
//                         res = a - b;
//                         break;
//                     case "*":
//                         res = a * b;
//                         break;
//                     case "/":
//                         res = a / b;  // integer division truncates toward zero
//                         break;                     
//                 }
//                 stack.push(res);
//             } else {
//                 stack.push(Integer.parseInt(token));
//             }
//         }
//         return stack.pop();
//     }

//     private boolean isOperator(String s) {
//         return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
//     }
// }

/**
Built-in Way to Detect a Number：
    Character.isDigit('5')  // true
    Character.isDigit('+')  // false

But Here’s the Catch： In RPN, tokens are strings, not single characters.
    "2"
    "-11"
    "+"

 */


