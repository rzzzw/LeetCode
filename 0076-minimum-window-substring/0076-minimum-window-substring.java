class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();  // frequency of characters in t
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>(); // frequency of characters in current window
        int required = need.size();
        int formed = 0;  // how many characters meet their required frequency

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c =s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left; 
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}


// class Solution {
//     public String minWindow(String s, String t) {
//         if (s.length() < t.length()) {
//             return "";
//         }
//         int[] need = new int[128];
//         int needCount = t.length();
//         for (char c : t.toCharArray()) {
//             need[c]++; // c is a char not a number, can it be wrote like this?
//         }

//         int minLen = Integer.MAX_VALUE;
//         int minStart = 0;
//         int left = 0;
//         for (int right = 0; right < s.length(); right++) {
//             char c = s.charAt(right);
//             if (need[c] > 0) {
//                 needCount--;
//             }
//             need[c]--;

//             while (needCount == 0) {
//                 int winLen = right - left + 1;
//                 if (winLen < minLen) {
//                     minLen = winLen;
//                     minStart = left;
//                 }
//                 char leftChar = s.charAt(left);
//                 need[leftChar]++;
//                 if(need[leftChar] > 0) {
//                     needCount++;
//                 }
//                 left++;
//             }
//         }
//         return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);

//     }
// }
/**
    i   j
s: AEBSCZSCESZ
t: ZES

 */