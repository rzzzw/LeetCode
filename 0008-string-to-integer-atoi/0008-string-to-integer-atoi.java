class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray(); 
        int i = 0;
        
        int n = ch.length;

        // 1. skip spaces
        while (i < n && ch[i] == ' ') {
            i++;
        }

        // 2. Sign
        int sign = 1;
        if (i < n && (ch[i] == '-' || ch[i] ==  '+')) {
            sign = (ch[i] == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert digits
        int num = 0;
        while (i < ch.length && (ch[i] - '0') >= 0 && (ch[i] - '0') <= 9) { // Character.isDigit(ch[i])
            int digit = ch[i] - '0';
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // num *= 10;
            // num += (ch[i] - '0');
            num = num * 10 + digit;
            i++;
        }
        return num * sign;
    }
}