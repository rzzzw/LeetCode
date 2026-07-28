class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        int longest = 0;
        int l = 0;     
        for (int r = 0; r < arr.length; r++) {
            while (set.contains(arr[r])) {
                set.remove(arr[l]);
                l++;
            }
            set.add(arr[r]);
            longest = Math.max(r - l + 1, longest);
        }
        return longest;
    }
}
