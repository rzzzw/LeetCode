class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}




/**

Convert a num to binary: 
    0 --> 0
    1 --> 1
    2 --> 10
        Division        Quotient        Remainder
        2 / 2               1               0
        1 / 2               0               1
        Read bottom -> top: 10         
                            2^1 = 2
    3 --> 11
        Division        Quotient        Remainder
        3 / 2               1               1
        1 / 2               0               1
        Read bottom -> top: 11  
                            2^1 + 2^0 = 3
    4 --> 100  
        Division        Quotient        Remainder
        4 / 2               2               0
        2 / 2               1               0
        1 / 2               0               1
        Read bottom -> top: 100
                            2^2 = 4
    5 --> 101
        Division        Quotient        Remainder
        5 / 2               2               1
        2 / 2               1               0
        1 / 2               0               1
        Read bottom -> top: 101       
                            2^2 + 2^0 = 5
    6 --> 110
        Division        Quotient        Remainder
        6 / 2               3               0
        3 / 2               1               1
        1 / 2               0               1
        read bottom -> top: 110
                            2^2 + 2^1 = 6
    7 --> 111
        Division        Quotient        Remainder
        7 / 2               3               1
        3 / 2               1               1
        1 / 2               0               1
        Read bottom -> top: 111  
                            2^2 + 2^1 + 2^0 = 7

    dp[i] = dp[i / 2] + (i % 2) 

    or in bit form
    dp[i] = dp[i >> 1] + (i & 1)
    (in this expression above, i is a decimal (base-10) integer.Bitwise operators work on the binary representation of that decimal integer.

 */