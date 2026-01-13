class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private void helper(String s, int start, ArrayList<String> cur, List<List<String>> res){
        if (start >= s.length()) {
            res.add(new ArrayList<String>(cur));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                cur.add(s.substring(start, end + 1));
                helper(s, end + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
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
//         List<List<Integer>> res = new ArrayList<>();
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