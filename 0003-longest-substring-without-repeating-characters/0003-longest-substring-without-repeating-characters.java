class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] input = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int longest = 0;
        for (int fast = 0; fast < input.length; fast++) {
            while (set.contains(input[fast])) {
                set.remove(input[slow]);
                slow++;
            }
            set.add(input[fast]);
            longest = Math.max(longest, fast - slow + 1);
        }
        return longest;
    }
}



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
//                     // Math.max()!!
//             }    
//             // while (distinct.containsKey(input[fast])) {
//                 // distinct.remove(input[slow]);
//                 // slow++;     
//             // }
//             longest = Math.max(longest, fast - slow + 1);
//             distinct.put(input[fast], fast);
//         }
//         return longest;
    
//     }
// }


/**
    s
    abcabcbb
       f

      s
    abba
       f
longest = 2
map:
    a: 0
    b: 2

 */




