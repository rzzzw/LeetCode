class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '{') {
                stack.offerFirst('}');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.pollFirst() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}




// class Solution {
//     public boolean isValid(String s) {
//         if (s == null || s.length() == 0) {
//             return true;
//         }
//         Map<Character, Character> map = new HashMap<>();
//         map.put(')', '(');
//         map.put(']', '[');
//         map.put('}', '{');

//         Deque<Character> stack = new ArrayDeque<>();
//         for (char c : s.toCharArray()) {
//             if (map.containsKey(c)) {
//                 if (stack.isEmpty() || stack.peekFirst() != map.get(c)) {
//                     return false;
//                 }
//                 stack.pollFirst();
//             } else {
//                 stack.offerFirst(c);
//             }
//         }  
//         return stack.isEmpty();      
//     }
// }
