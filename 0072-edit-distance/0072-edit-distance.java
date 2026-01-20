class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        return helper(word1, word2, m - 1, n - 1, dp);
    }

    private int helper(String a, String b, int i, int j, int[][] dp) {  // i: idx of a;   j: idx of b
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = helper(a, b, i - 1, j - 1, dp);
        }
        dp[i][j] = Math.min(1 + helper(a, b, i - 1, j, dp), 1 + helper(a, b, i, j - 1, dp));
        dp[i][j] = Math.min(dp[i][j], 1 + helper(a, b, i - 1, j - 1, dp));
        return dp[i][j];
    }
}

// class Solution {
//     public int minDistance(String word1, String word2) {
//         int m = word1.length();
//         int n = word2.length();
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 0; i <= m; i++) {
//             for (int j = 0; j <= n; j++) {
//                 if (i == 0) {
//                     dp[i][j] = j;
//                 } else if (j == 0) {
//                     dp[i][j] = i;
//                 } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
//                     dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
//                 }

//             }
//         }
//         return dp[m][n];
//     }
// }
/**
Constrains & edge cases:
    - Lengths up to ~500
    - Strings can be empty => one string empty -> cost = length of the other
    - Characters are lowercase letters
Edge cases:
    - One string empty → cost = length of the other
    - Strings already equal → cost = 0

Step 2: Key observation (THIS IS THE CORE)
    dp[i][j] = minimum edits to convert word1[0..i-1] → word2[0..j-1]
    This is the most important line in the interview.

Step 3: Think about the LAST character:     word1[i-1] vs. word2[j-1]
    Case 1: Characters match: word1[i-1] == word2[j-1]
            No operation needed: dp[i][j] = dp[i - 1][j - 1]
    Case 2: Characters differ - must do one operation:
                                Meaning                             Transition                          Explaination
            1. Insert           Insert word2[j-1]                   dp[i][j - 1] + 1                    Match shorter word2, then insert
            2. Delete           Delete word1[i-1]                   dp[i - 1][j] + 1                    Remove char from word1
            3. Replace          Replace word1[i-1] → word2[j-1]     dp[i - 1][j - 1] + 1                Fix last mismatch

            dp[i][j] = 1 + min(
                dp[i-1][j],     // delete
                dp[i][j-1],     // insert
                dp[i-1][j-1]    // replace
            )


 */

// class Solution{
//     public int minDistance(String word1, String word2) {
//         int m = word1.length();
//         int n = word2.length();

//         int[][] dp = new int[m + 1][n + 1];

//         // base cases
//         for (int i = 0; i <= m; i++) {
//             dp[i][0] = i;
//         }
//         for (int j = 0; j <= n; j++) {
//             dp[0][j] = j;
//         }

//         // fill DP table
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }