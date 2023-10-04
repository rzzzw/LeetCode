class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int n = arr.length;
        int idx = 0;
        while (idx < n && arr[idx] == ' ') {
            idx++;
        }
        
        if (idx == n) return 0;
        
        int sign = 1;
        if (arr[idx] == '-' || arr[idx] == '+') {
            sign = arr[idx] == '-' ? -1 : 1;
            idx++;
        }
        
        int res = 0;
        while (idx < n) {
            int digit = arr[idx] - '0';
            if (digit < 0 || digit > 9) break;

            int newRes = res * 10 + digit;
            
            // --------- check the boundary -------------
            
            // Method 1:
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            // method 2:
            // if (newRes / 10 != res) {
            //     return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            // }
            
            // ------------------------------------------
            
            res = newRes;
            idx++;
        }
        return res * sign;
        
    }
}