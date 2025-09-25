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
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (fast < arr.length) {
            if (!set.contains(arr[fast])) {
                set.add(arr[fast]);
                fast++;
                longest = Math.max(longest, fast - slow);
            } else {
                set.remove(arr[slow]); // 错误点： set.remove(arr[fast]), 只remove了重复的那一个字符，而不是那个字符及左边的所有字符
                slow++;
            }
        }
        return longest;
    }
}