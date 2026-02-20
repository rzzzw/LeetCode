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
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean hasOdd = false;
        int res = 0;
        for (int n : count) {
            res += (n / 2) * 2; // add largest even part
            if (n % 2 == 1) {
                hasOdd = true;
            }
            // if (n % 2 == 0) {
            //     res += n;
            // } else {
            //     res += n - 1;
            //     hasOdd = true;
            // }
        }
        return hasOdd ? (res + 1) : res;
    } 
}

