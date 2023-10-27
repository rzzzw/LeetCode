class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        int MOD = 1_000_000_000 + 7;
        long[][] dp = new long[goal+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= Math.min(i, n); j++) {
                // 1. add new song
                dp[i][j] = dp[i - 1][j - 1] * (n - (j - 1)) % MOD;
                
                // 2. repeat old song
                if (j > k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % MOD; 
                }
            }
        }
        return (int)dp[goal][n];
    }
}

/*

0 <= k < n <= goal <= 100

dp[i][j]: the # of possible playlists of length i, containing exactly j unique songs.

dp[goal][n]: the # of ways we can make a playlist of length goal using exactly n unique songs.
  goal >= n

Base case:
    dp[0][0] = 1 (1 way to create the playlist of length 0 with 0 unique songs <=> an empty playlist.)
    for all i < j (goal < n): dp[i][j] = 0

How to get dp[i][j]:
  1. add a new song to the playlist:
     dp[i][j]=dp[i-1][j-1]+1
                           ^ total n unique songs, the remaining # of new songs we can choose: n-(j-1) => n-j+1
        => dp[i-1][j-1]*(n-j+1)
  2. replay an old song:
     dp[i][j]=dp[i-1][j]  constrain: "A song can only be played again only if k other songs have been played."
     => if j>k, the # of old songs we can choose to replay: j-k
     => dp[i-1][j]*(j-k)


**/