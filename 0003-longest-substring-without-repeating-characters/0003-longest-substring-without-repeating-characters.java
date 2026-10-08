// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if (s == null || s.length() == 0) {
//             return 0;
//         }
//         char[] arr = s.toCharArray();
//         Set<Character> set = new HashSet<>();
//         int longest = 0;
//         int l = 0;
//         for (int r = 0; r < arr.length; r++) {
//             while(set.contains(arr[r])){
//                 set.remove(arr[l]);
//                 l++;
//             }
//             set.add(arr[r]);
//             longest = Math.max(r - l + 1, longest);
//         }
//         return longest;
//     }
// }
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }    
        int[] lastSeen = new int[128];
        int left = 0;
        int longest = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            left = Math.max(left, lastSeen[ch]);
            longest = Math.max(longest, r - left + 1);
            lastSeen[ch] = r + 1;
        }    
        return longest;
    }
}
