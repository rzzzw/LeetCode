/**
Time: O(n * max_repeat)
Space: O(n)
 */

class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            else if (c == '[') {
                countStack.push(num);
                stringStack.push(cur);
                cur = new StringBuilder();
                num = 0;
            }
            else if (c == ']') {
                int times = countStack.pop();
                StringBuilder prev = stringStack.pop();
                for (int i= 0; i < times; i++) {
                    prev.append(cur);
                }
                cur = prev;
            }
            else {
                cur.append(c);
            }
        } 
        return cur.toString();
    }
}

// class Solution {
//     public String decodeString(String s) {
//         Deque<Character> stack = new ArrayDeque<>();
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == ']') {
//                 List<Character> decodedString = new ArrayList<>();
//                 while (stack.peek() != '[') {
//                     decodedString.add(stack.pop());
//                 }
//                 stack.pop(); // pop '['
//                 int base = 1;
//                 int k = 0;
//                 while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
//                     k = k + (stack.pop() - '0') * base;
//                     base *= 10;
//                 }
//                 while (k != 0) {
//                     for (int j = decodedString.size() - 1; j >= 0; j--) {
//                         stack.push(decodedString.get(j));
//                     }
//                     k--;
//                 }
//             }
//             else {
//                 stack.push(s.charAt(i));
//             }
//         }

//         char[] res = new char[stack.size()];
//         for (int i = res.length - 1; i >= 0; i--) {
//             res[i] = stack.pop();
//         }
//         return new String(res);
//     }
// }