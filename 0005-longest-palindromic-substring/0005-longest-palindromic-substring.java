class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        char[] arr = s.toCharArray();
        int maxLen = 1;
        int left = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.max(getPalinLen(arr, i, i), getPalinLen(arr, i, i + 1));
            if (maxLen < len) {
                maxLen = len;
                left = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(left, left + maxLen);
    }

    private int getPalinLen(char[] arr, int l, int r) {
        while (l >= 0 && r < arr.length && arr[l] == arr[r]) {
            l--;
            r++;
        }
        return r - l - 1; // attention: the locations of l & r are both 1 step outter of the start & end points of the length.
    }
}



// class Solution {
//     public String longestPalindrome(String s) {
//         if (s == null || s.length() <= 1) return s;
//         int n = s.length();
//         char[] arr = s.toCharArray();
//         int maxLen = 1;
//         int head = 0;

//         for (int i = 0; i < n; i++) {
//             int len = Math.max(getPalinLen(arr, i, i), getPalinLen(arr, i, i + 1));
//             if (len > maxLen) {
//                 maxLen = len;
//                 head = i - (len - 1) / 2;
//             }
//         }
//         return new String(arr, head, maxLen);
//     }
//     private int getPalinLen(char[] arr, int l, int r) {
//         while(l >= 0 && r < arr.length && arr[l] == arr[r]) {
//             l--;
//             r++;
//         }
//         return r - l - 1;
//     }
// }

/**
1️⃣ Problem Understanding

2️⃣ Interview Strategy
    Start with brute force to show understanding
    Observe palindrome symmetry
    Optimize using expand-around-center
    Mention DP / Manacher’s as alternatives (but don’t code unless asked)

3️⃣ Step-by-Step Solution Development
    Step 1: Brute force O(n^3): 
        Enumerate all substrings (Total substrings = O(n²))
        Check each for palindrome (Palindrome check = O(n))
        => O(n³) 🚫
    Step 2: Key Observation
        A palindrome is defined by its center.
        Centers can be:
          - One character (odd length)
          - Between two characters (even length)
        Total centers = 2n - 1
    Step 3: Expand Around Each Center (O(n²))
        For each center:
          - Expand left and right
          - Stop when characters differ
          - Track the longest valid range
        This avoids rechecking substrings.



 */


// class Solution {
//     public String longestPalindrome(String s) {
//         if (s == null || s.length() == 0) {
//             return s;
//         }
//         int start = 0;
//         int maxLen = 1;

//         for (int i = 0; i < s.length(); i++) {
//             int len1 = expandFromCenter(s, i, i);
//             int len2 = expandFromCenter(s, i, i + 1);
//             int curMax = Math.max(len1, len2);
//             if (curMax > maxLen) {
//                 maxLen = curMax;
//                 start = i - (maxLen - 1) / 2;   // "abba / aba"
//             }
//         }
//         return s.substring(start, start + maxLen);
//     }

//     private int expandFromCenter(String s, int left, int right) {
//         while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//             left--;
//             right++;
//         }
//         return right - left - 1;
//     }
// }

/**
Why the (maxLen - 1)?
The -1 is the "secret sauce" that handles the offset for even-length palindromes. 
• For odd lengths, (maxLen - 1) is always even, so dividing by 2 gives you exactly how many steps to move back from the center.
• For even lengths, the center i is technically the left-middle character. Subtracting 1 before dividing "shifts" the math so that you don't move back too far. 

s.substring() is overloaded with two common forms: 
• s.substring(int beginIndex)
    Returns a substring starting from beginIndex (inclusive) to the very end of the string.
• s.substring(int beginIndex, int endIndex)
    Returns a substring starting from beginIndex (inclusive) and ending at endIndex (exclusive). 

 */


