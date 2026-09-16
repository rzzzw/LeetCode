/**
        applepenapple       ["apple","pen"]

M[i] represent 长度为i的string能不能切成每一份都在字典里
M[i] = true if s[0..i-1] can be segmented
M[0] = T

M[i] = true if there exists j such that:
    M[j] == true
    AND s[j..i-1] ∈ wordDict

len = 1 -- 'a' : M[1] = F
len = 2 -- 'ap':
    0': 
        |ap
        M[0] && 'ap'is not in the dict - F
    1':
        a|p
        M[1] && "p" is not in the dict - F
    M[2] = (F || F) = F
len = 3 -- 'app':
    0': |app => M[0] && 'app'is not in the dict - F
    1': a|pp => M[1] && 'pp'is not in the dict - F
    2': ap|p => M[2] && 'p'is not in the dict - F     
    M[3] = (F||F||F) = F 


 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] M = new boolean[s.length() + 1]; // M[i] represent 长度为i的string能不能切成每一份都在字典里
        M[0] = true;

        // Find the maximum word length in the dictionary
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        for (int len = 1; len <= s.length(); len++) {
            // Only look back as far as the longest word in the dictionary
            int startLimit = Math.max(0, len - maxLen); 
            for (int i = len - 1; i >= startLimit; i--) {
                if (M[i] && set.contains(s.substring(i, len))) {
                    M[len] = true;
                    break;
                }
            }
        }
        return M[s.length()];
    }
} 
/*
len     1234567...
idx     0123456...  
        applepenapple
len = 5
maxLen = 5

i = 5-1= 4 -> 5-5=0
M[4] && e
M[3] && le
M[2] && ple
M[1] && pple
M[0] && apple 
        =>  M[5] = true

len = 6
startLimit = Math.max(0, 6 - 5) = 1
i = 5 -> 1
M[5] && p
M[4] && ep
M[3] && lep
M[2] && plep
M[1] && pplep
        =>  M[6] = false

*/

// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> set = new HashSet<>(wordDict);
//         boolean[] M = new boolean[s.length() + 1];
//         M[0] = true;
//         for (int len = 1; len <= s.length(); len++) {
//             for (int i = 0; i < len; i++) {
//                 if (M[i] && set.contains(s.substring(i, len))) { 
//                     M[len] = true;
//                     break;
//                 }
//             }
//         }
//         return M[s.length()];
//     }
// }


/**
Breadth-First Search
Time complexity: n^3
*/
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> words = new HashSet<>(wordDict);
//         Queue<Integer> queue = new ArrayDeque<>();
//         boolean[] seen = new boolean[s.length() + 1];
//         queue.add(0);

//         while (!queue.isEmpty()) {
//             int start = queue.poll();
//             if (start == s.length()) {
//                 return true;
//             }
//             for (int end = start + 1; end <= s.length(); end++) {
//                 if (seen[end]) {
//                     continue;
//                 }
//                 if (words.contains(s.substring(start, end))) {
//                     seen[end] = true;
//                     queue.add(end);
//                 }
//             }
//         }
//         return false;
//     }
// }

