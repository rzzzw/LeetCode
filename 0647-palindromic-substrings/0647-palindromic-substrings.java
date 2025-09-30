
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) { // n 和 len 都是长度 
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;

    }
}

/**
    0 1 2 3 4
    a b c b d
0 a T F F F F
1 b   T F T F
2 c     T F F
3 b       T F
4 d         T


 */