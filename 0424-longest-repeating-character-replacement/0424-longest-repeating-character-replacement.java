class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        int maxCount = 0;
        int left = 0;
        int right = 0; 
        //[left, right) 区间内最多替换k个字符可以得到只有一种字符的字串， 区间左闭右开，长度=right-left
        while (right < len) {
            freq[arr[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[arr[right] - 'A']);
            right++;

            if (right - left > maxCount + k) {
                freq[arr[left] - 'A']--;
                left++;
            }
        }
        return right - left;
    }
}

/**
Time O(N)
Space: O(字符种类数)

practice：1004， 1208， 1493

 */

 