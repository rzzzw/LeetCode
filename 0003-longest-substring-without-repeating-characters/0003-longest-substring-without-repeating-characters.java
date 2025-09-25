// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) {
//             return 0;
//         }


//         char[] input = s.toCharArray();
//         Map<Character, Integer> distinct = new HashMap<>();
//         int longest = 0;
//         int slow = 0;
//         for (int fast = 0; fast < input.length; fast++) {
//             if (distinct.containsKey(input[fast])) {
//                 slow = Math.max(distinct.get(input[fast]) + 1, slow);  // avoid move slow point step by step via this method
//             }    
//             // while (distinct.containsKey(input[fast])) {
//                 // distinct.remove(input[slow]);
//                 // slow++;     
//             // }
//             longest = Math.max(longest, fast - slow + 1);
//             distinct.put(input[fast], fast);
//         }
//         return longest;
        
//         // Set<Character> distinct = new HashSet<>();
//         // int slow = 0;
//         // int fast = 0;
//         // int longest = 0;
//         // while (fast < s.length()) {
//         //     if (distinct.contains(s.charAt(fast))){
//         //         distinct.remove(s.charAt(slow));
//         //         slow++;
//         //     } else {
//         //         distinct.add(s.charAt(fast));
//         //         fast++;
//         //         longest = Math.max(longest, fast - slow);
//         //     }
//         // }
//         // return longest;
//     }
// }


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int maxLen = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                slow = Math.max(map.get(c) + 1, slow);
            }
            map.put(c, fast);
            maxLen = Math.max(maxLen, fast - slow + 1);
        }
        return maxLen;
    }
}