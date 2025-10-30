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

Why use maxCount + k?
    maxCount = number of the most frequent character in the window
    (right - left) = total window size
    
    → the rest (right - left) - maxCount = characters we would need to replace

   0 1 2 3
   A B A B
     l
            r

   A B C D
   0 1 2 3
   1 2

practice：1004， 1208， 1493

 */

