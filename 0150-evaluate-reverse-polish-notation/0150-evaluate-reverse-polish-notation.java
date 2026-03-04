class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.poll();
                int a = stack.poll();
                int res = 0;

                switch (token) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        res = a / b;  // integer division truncates toward zero
                        break;                     
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }
}


