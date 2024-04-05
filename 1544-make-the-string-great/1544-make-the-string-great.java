class Solution {
    public String makeGood(String s) {     
        if (s.length() < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 1) {
            char cur = sb.charAt(i);
            char next = sb.charAt(i + 1);
            if (Math.abs(next - cur) == 32) {
                // sb.deleteCharAt(i);
                // sb.deleteCharAt(i);
                sb.delete(i, i + 2);   // the TC of StringBuilder delete operation is O(n)
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}


/*
TC: worst case - O(n^2)
SC: O(n)
*/