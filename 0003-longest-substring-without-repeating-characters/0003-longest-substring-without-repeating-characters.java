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
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int curLen = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            char curChar = arr[fast];
            if(!map.containsKey(curChar)) {
                map.put(curChar, fast);  
                curLen++;         
            } else {
                curLen = fast - map.get(curChar);
                map.put(curChar, fast);            
            }
            res = Math.max(res, curLen);
        }
        return res;
    }
}