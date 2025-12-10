class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] need = new int[128];
        int needCount = t.length();
        for (char c : t.toCharArray()) {
            need[c]++; // c is a char not a number, can it be wrote like this?
        }

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need[c] > 0) {
                needCount--;
            }
            need[c]--;

            while (needCount == 0) {
                int winLen = right - left + 1;
                if (winLen < minLen) {
                    minLen = winLen;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                need[leftChar]++;
                if(need[leftChar] > 0) {
                    needCount++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);

    }
}
/**
    i   j
s: AEBSCZSCESZ
t: ZES

 */