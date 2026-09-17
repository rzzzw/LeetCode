/**
Maintain a sliding window of size p.length() and track frequency matches.

Core pattern
- Precompute frequency of p
- Slide a Window of size p.length()
- Update frequency as window moves
- Track when all counts match

Key trick (very interview-relevant) - Instead of comparing entire arrays each time, track:
    matches: number of characters whose frequency matches p
    
Time: O(n)
Space: O(1)
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        } 
        if (p.length() > s.length()) {
            return res;
        }
        int[] charNeed = new int[26];
        int[] window = new int[26];
        int required = 0;

        for (char c : p.toCharArray()) {
            charNeed[c - 'a']++;
        }

        for (int c : charNeed) {    
            if (c > 0) {
                required++;
            }
        }

        int matched = 0;
        int i = 0;  // window: i...j

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            int idx = c - 'a';

            window[idx]++;
            if (window[idx] == charNeed[idx]) {
                matched++;
            }

            if (j - i + 1 > p.length()) {
                char leftChar = s.charAt(i);
                int leftIdx = leftChar - 'a';
                if (window[leftIdx] == charNeed[leftIdx]) {
                    matched--;
                }
                window[leftIdx]--;
                i++;
            }

            if(matched == required) {
                res.add(i);
            }

        }
        return res;

    }
}



// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         List<Integer> res = new ArrayList<>();
//         if (s == null || p == null || s.length() < p.length()) {
//             return res;
//         }
//         int[] map = new int[26];
//         int numOfChar = 0;
//         for (char c : p.toCharArray()) {
//             map[c - 'a']++;
//             if (map[c - 'a'] == 1) {
//                 numOfChar++;
//             }
//         }

//         int lo = 0;
//         for (int i = 0; i < s.length(); i++) {
//             char head = s.charAt(i);
//             map[head - 'a']--;
//             if (map[head - 'a'] == 0) {
//                 numOfChar--;
//             }
//             if (i - lo + 1 > p.length()) {
//                 char tail = s.charAt(lo++); // lo++!!!!
//                 map[tail - 'a']++;
//                 if (map[tail - 'a'] == 1) {
//                     numOfChar++;
//                 }
//             }
//             if (numOfChar == 0) {
//                 res.add(lo);
//             }
//         } 
//         return res;
//     }
// }