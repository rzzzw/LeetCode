class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1 || numRows >= s.length()) {
            return s;
        }
        char[] c = s.toCharArray();
        int len = s.length();
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        
        int idx = 0;
        while (idx < len) {
            for (int i = 0; i < numRows && idx < len; i++) {
                sb[i].append(c[idx++]);
            }
            for (int i = numRows - 2; i >= 1 && idx < len; i--) {
                sb[i].append(c[idx++]);
            }
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}