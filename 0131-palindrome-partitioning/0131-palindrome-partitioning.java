// class Solution {
//     public List<List<String>> partition(String s) {
//         List<List<String>> res = new ArrayList<>();
//         if (s == null || s.length() == 0) {
//             return res;
//         }
//         helper(s, 0, new ArrayList<>(), res);
//         return res;
//     }

//     private void helper(String s, int start, List<String> path, List<List<String>> res) {
//         if (start == s.length()) {
//             res.add(new ArrayList<>(path));
//             return;
//         }

//         for (int end = start; end < s.length(); end++) { 
//             if (isPalindrome(s, start, end)) {   
//                 path.add(s.substring(start, end + 1));
//                 helper(s, end + 1, path, res);
//                 path.remove(path.size() - 1);
//             }
//         }
//     }

//     private boolean isPalindrome(String s, int start, int end) {
//         while (start < end) {
//             if (s.charAt(start++) != s.charAt(end--)) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }
/**
Time complexity n^2 * 2^n: 
- Between each pair of adjacent characters you can either cut or not cut. O(2^n)
- Each candidate substring is checked using isPalindrome(s, start, end). O(n)
- When a complete partition is found, copying path res.add(new ArrayList<>(path)).  O(n)

Space: O(n)
The recursion depth is at most n, and path can contain at most n substrings
 */


class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int n = s.length();
        boolean[][] isPalindrome = buildPalindromeTable(s);
        backtrack(s, 0, new ArrayList<>(), res, isPalindrome);
        return res;
    }
    private void backtrack(String s, int start, List<String> path, List<List<String>> res, boolean[][] isPalindrome) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (!isPalindrome[start][end]) {
                continue;
            }
            path.add(s.substring(start, end + 1));
            backtrack(s, end + 1, path, res, isPalindrome);
            path.remove(path.size() - 1);
        }
    }
    private boolean[][] buildPalindromeTable(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int start = 0; start + len - 1 < n; start++) {
                int end = start + len - 1;
                if (s.charAt(start) == s.charAt(end)) {
                    // dp[start][end] = (len <= 2) || dp[start + 1][end - 1];
                    if (len <= 2) {
                        dp[start][end] = true;
                    } else {
                        dp[start][end] = dp[start + 1][end - 1];
                    }
                }
            }
        }
        return dp;
    }
}
/**
Time Complexity:
    Palindrome DP: O(n²)
    Backtracking: exponential (number of valid partitions)

Space Complexity: O(n²)

 */