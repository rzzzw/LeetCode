class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // char[] input = s.toCharArray();
        // Map<Character, Integer> map = new HashMap<>();
        // int longest = 0;
        // int i = 0;
        // for (int j = 0; j < input.length; j++) {
        //     if (map.containsKey(input[j])) {
        //         i = Math.max(map.get(input[j]) + 1, i);
        //     }
        //     longest = Math.max(longest, j - i + 1);
        //     map.put(input[j], j);
        // }
        // return longest;
        
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (fast < s.length()) {
            if (distinct.contains(s.charAt(fast))){
                distinct.remove(s.charAt(slow));
                slow++;
            } else {
                distinct.add(s.charAt(fast));
                fast++;
                longest = Math.max(longest, fast - slow);
            }
        }
        return longest;
    }
}