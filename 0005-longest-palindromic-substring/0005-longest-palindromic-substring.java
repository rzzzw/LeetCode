class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int n = s.length();
        char[] arr = s.toCharArray();
        int maxLen = 1;
        int head = 0;

        for (int i = 0; i < n; i++) {
            int len = Math.max(getPalinLen(arr, i, i), getPalinLen(arr, i, i + 1));
            if (len > maxLen) {
                maxLen = len;
                head = i - (len - 1) / 2;
            }
        }
        return new String(arr, head, maxLen);
    }
    private int getPalinLen(char[] arr, int l, int r) {
        while(l >= 0 && r < arr.length && arr[l] == arr[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}

