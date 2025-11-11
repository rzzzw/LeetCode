public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i < c) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}

/**
example: 
    amount = 6
         0 1 2 3 4 5 6
    dp: [0 7 7 7 7 7 7]
        
    coins: [1, 2, 3]

Induction Rule
    dp[i] = minimum coins to make up amount i

Base case: dp[0] = 0; to make amount = 0, we need 0 coins.

Recurrence:
    dp[i] = min(dp[i - coin] + 1) for all coin ≤ i
    
    Iterate i from 1 to amount.

Time: O(amount * n) — for each amount, try every coin.
Space: O(amount)

 */