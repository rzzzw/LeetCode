class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] input = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int slow = 0;
        for (int fast = 0; fast < input.length; fast++) {
            if (map.containsKey(input[fast])) {
                slow = Math.max(map.get(input[fast]) + 1, slow);
            }
            longest = Math.max(longest, fast - slow + 1);
            map.put(input[fast], fast);
        }
        return longest;
    }
}

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




