// class Solution {
//     public int longestPalindrome(String s) {
//         if (s == null || s.length() == 0) {
//             return 0;
//         }
//         Map<Character, Integer> map = new HashMap<>();
//         for (char c : s.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
//         boolean hasOdd = false;
//         int res = 0;
//         for (int n : map.values()) {
//             if (n % 2 == 0) {
//                 res += n;
//             } else {
//                 res += n - 1;
//                 hasOdd = true;
//             }
//         }
//         return hasOdd ? (res + 1) : res;
//     } 
// }

class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = new int[128]
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean hasOdd = false;
        int res = 0;
        for (int n : count) {
            if (n % 2 == 0) {
                res += n;
            } else {
                res += n - 1;
                hasOdd = true;
            }
        }
        return hasOdd ? (res + 1) : res;
    } 
}

// class Solution {
//     public int longestPalindrome(String s) {
//         int[] count = new int[128];  // ASCII size
        
//         // Count frequency of each character
//         for (char c : s.toCharArray()) {
//             count[c]++;
//         }
        
//         int length = 0;
//         boolean hasOdd = false;
        
//         for (int c : count) {
//             length += (c / 2) * 2;  // add largest even part
//             if (c % 2 == 1) {
//                 hasOdd = true;
//             }
//         }
        
//         // If any character has odd count, we can place one in the middle
//         if (hasOdd) {
//             length += 1;
//         }
        
//         return length;
//     }
// }