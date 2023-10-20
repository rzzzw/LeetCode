class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int l = 0;
        int maxLen = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);
            charCount.put(cur, charCount.getOrDefault(cur, 0) + 1);
            while (charCount.size() > k) {
                char leftChar = s.charAt(l);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                l++;
            }  
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}


/**
TC: O(n)
SC: O(k)
*/