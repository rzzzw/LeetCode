// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) {
//             return 0;
//         }
//         int slow = 0;
//         Set<Character> set = new HashSet<>();
//         int longest = 0;
//         for (int fast = 0; fast < s.length(); fast++) {
//             while (set.contains(s.charAt(fast))) {
//                 set.remove(s.charAt(slow));
//                 slow++;
//             }
//             set.add(s.charAt(fast));
//             longest = Math.max(longest, fast - slow + 1);
//         }
//         return longest;
//     }
// }


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



class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        int longest = 1;
        int l = 0;   
        int r = 1;
        set.add(arr[l]);    
        while(r < arr.length) {
            char c = arr[r];
            if (!set.contains(c)) {
                set.add(c);
                longest = Math.max(r - l + 1, longest);
                r++;
            } else {
                set.remove(arr[l]);
                l++;
            }
        }
        return longest;
    }
}
