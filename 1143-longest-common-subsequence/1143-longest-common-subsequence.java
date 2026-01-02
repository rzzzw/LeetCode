/**
DP definition:
dp[i][j] = length of LCS between:
           text1[0..i-1] and text2[0..j-1]  (i and j represent lengths, not indices)
Base case:
          dp[0][*] = 0
          dp[*][0] = 0

Transition rules (core logic):
    compare text1.charAt(i - 1) and text2.charAt(j - 1)
    1' Characters match -> text1[i - 1] == text2[j - 1]
        extend the LCS: dp[i][j] = dp[i - 1][j - 1] + 1
    2' Characters do NOT match -> text1[i - 1] != text2[j - 1]
        skip one character (try both possibilities):
            dp[i][j] = max(
                dp[i - 1][j],   // skip text1 char
                dp[i][j - 1]    // skip text2 char
            )

 */

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();

//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 1; i <= m;  i++) {
//             for (int j = 1; j <= n; j++) {
//                 if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1] + 1;
//                 } else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        // dp[i][j]: length of longest common subsequence between:
        //            text1[0..i-1] and text2[0..j-1] (i and j represent lengths, not indices)
        // base case:
        // dp[0][j] = 0
        // dp[i][0] = 0

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}