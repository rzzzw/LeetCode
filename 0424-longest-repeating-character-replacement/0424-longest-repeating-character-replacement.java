/* 
In any window: window size - count of most frequent char ≤ k

changes needed = windowSize - maxFreq

Keep the window where (size - maxFreq ≤ k), and expand as much as possible.
If (window size - maxFreq > k) → shrink window

 **/
 class Solution {
    public int characterReplacement(String s, int k) {
        // assume s!= null
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        int maxCount = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            freq[arr[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[arr[right] - 'A']);
            right++;

            if (right - left > maxCount + k) { // If (window size - maxFreq > k) → shrink window
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

practice：1004， 1208， 1493

 */

