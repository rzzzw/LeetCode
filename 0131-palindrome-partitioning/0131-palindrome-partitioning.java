class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(String s, int start, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                helper(s, end + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}

// class Solution {
//     public List<List<String>> partition(String s) {
//         int n = s.length();
//         boolean[][] isPalindrome = buildPalindromeTable(s);
//         List<List<String>> res = new ArrayList<>();
//         backtrack(s, 0, isPalindrome, new ArrayList<>(), res);
//         return res;
//     }

//     private void backtrack(String s, int start, boolean[][] isPalindrome, List<String> path, List<List<String>> res) {
//         if (start == s.length()) {
//             res.add(new ArrayList<>(path));
//             return;
//         }
//         for (int end = start; end < s.length(); end++) {
//             if (!isPalindrome[start][end]) {
//                 continue;
//             }
//             path.add(s.substring(start, end + 1));
//             backtrack(s, end + 1, isPalindrome, path, res);
//             path.remove(path.size() - 1);
//         }
//     }

//     private boolean[][] buildPalindromeTable(String s) {
//         int n = s.length();
//         boolean[][] dp = new boolean[n][n];

//         for (int len = 1; len <= n; len++) {
//             for (int i = 0; i + len - 1 < n; i++) {
//                 int j = i + len - 1;

//                 if (s.charAt(i) == s.charAt(j)) {
//                     dp[i][j] = (len <= 2) || dp[i + 1][j - 1];
//                 }
//             }
//         }
//         return dp;
//     }
// }
/**
Time Complexity:
    Palindrome DP: O(n²)
    Backtracking: exponential (number of valid partitions)

Space Complexity: O(n²)

 */
