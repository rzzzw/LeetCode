class Solution {
    public String removeDuplicates(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == c) {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char cur = stack.removeFirst();
            sb.append(cur);      
        }
        return sb.toString();
    }
}