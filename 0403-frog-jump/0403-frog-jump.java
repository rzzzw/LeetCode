class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[1][0] = true;

        for (int k = 1; k < n; k++) {       // first jump = 1; assum jump k + 1 (the maximum jump) every time
            if (stones[k] - stones[k - 1] > k) return false;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int dist = stones[i] - stones[j];
                // if (k > j + 1) break;
                // dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                // if (i == n - 1 && dp[i][k] ) return true;
                if (dist > j + 1)  break;
                dp[dist][i] = dp[dist - 1][j] || dp[dist][j] || dp[dist + 1][j];
                if (i == n - 1 && dp[dist][i]) return true;
            }
        }
        return false;
    }
}
/*
          0 1   2   3 4   5         6              7
stones = [0,1,  3,  5,6,  8,        12,            17]
              --  --    --  -------    -----------
          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
          


stone:         |s0|   |s1|        |s2|        |s3|
            ~~~|__|~~~|__|~~~~~~~~|__|~~~~~~~~|__|~~~~~~
position:       0      1           3           5
       

jump size:      1    [0,1,2]     [1,2,3]      

// if the frog can reach stone 1(s1) from s0 => dist(s0 -> s1) = 1 - 0 = 1, "first jump must be 1" so the frog is able to reach s1, and the next jump would be 0, 1, 2 units

// if the frog can reach stone 2(s2)?  
    1. if the frog comes from s0 (No) => dist(s0 -> s2) = 3 - 0 = 3. the frog couldn't make a jump of 3 units at s0
    2. if the from comes from s1 (Yes) => dist(s1 -> s2) = 3 - 1 = 2. the frog could make a jump of 2 units at s1, and the next jump could be 1, 2, 3 units
    
// if the frog can reach stone 3(s3)?  
    1. if the frog comes from s0 (No) => dist(s0 -> s3) = 5 - 0 = 5. the frog couldn't make a jump of 5 units at s0
    2. if the from comes from s1 (No) => dist(s1 -> s3) = 5 - 1 = 4. the frog couldn't make a jump of 4 units at s1
    3. if the from comes from s2 (Yes) => dist(s2 -> s3) = 5 - 3 = 2. the frog could make a jump of 2 units at s2, and the next jump could be 1, 2, 3 units

// if the frog can reach stone 4(s4)?  
    1. if the frog comes from s0 (No) => dist(s0 -> s4) = 6 - 0 = 6. the frog couldn't make a jump of 6 units at s0
    2. if the from comes from s1 (No) => dist(s1 -> s4) = 6 - 1 = 5. the frog couldn't make a jump of 5 units at s1
    3. if the from comes from s2 (Yes) => dist(s2 -> s4) = 6 - 3 = 3. the frog could make a jump of 3 units at s2, and the next jump could be 2, 3, 4 units
    4. if the from comes from s3 (Yes) => dist(s3 -> s4) = 6 - 5 = 1. the frog could make a jump of 1 units at s3, and the next jump could be 0, 1, 2 units

// if the frog can reach stone 5(s5)?  
    1. if the frog comes from s0 (No) => dist(s0 -> s5) = 8 - 0 = 8. the frog couldn't make a jump of 8 units at s0
    2. if the from comes from s1 (No) => dist(s1 -> s5) = 8 - 1 = 7. the frog couldn't make a jump of 7 units at s1
    3. if the from comes from s2 (No) => dist(s2 -> s5) = 8 - 3 = 5. the frog couldn't make a jump of 5 units at s2
    4. if the from comes from s3 (Yes) => dist(s3 -> s5) = 8 - 5 = 3. the frog could make a jump of 3 units at s3, and the next jump could be 2, 3, 4 units
    5. if the from comes from s4 (Yes) => dist(s4 -> s5) = 8 - 6 = 2. the frog could make a jump of 2 units at s4, and the next jump could be 1, 2, 3 units

// if the frog can reach stone 6(s6)?  
    1. if the frog comes from s0 (No) => dist(s0 -> s6) = 12 - 0 = 12. 
    2. if the from comes from s1 (No) => dist(s1 -> s6) = 12 - 1 = 11. 
    3. if the from comes from s2 (No) => dist(s2 -> s6) = 12 - 3 = 9.
    4. if the from comes from s3 (No) => dist(s3 -> s6) = 12 - 5 = 7. 
    5. if the from comes from s4 (No) => dist(s4 -> s6) = 12 - 6 = 6. 
     ^^^
     for (int i = 0; i < n; i++) {
        for (int j = i - 1; j >= 0; j--) {
            int dist = stones[i] - stones[j];
            if (!dp[dist][j])  {
                break;
            }
            ...
        }
     }
     dist = stones[index] - stones[j]
     if (stones[index] - stones[j] )
    6. if the from comes from s5 (Yes) => dist(s5 -> s6) = 12 - 8 = 4. the frog could make a jump of 4 units at s5, and the next jump could be 3, 4, 5 units
     ^^^
        ...
            dp[dist - 1][i] = true;
            dp[dist][i] = true;
            dp[dist + 1][i] = true;
        ...
    
    
index:              0   1   2   3   4   5   6   7    
stone position:   | 0 | 1 | 3 | 5 | 6 | 8 | 12| 17|
next jump:      0 | 0 | 1 | 0 | 0 | 1 | 0 | 0 | 
                1 | 1 | 1 | 1 | 1 | 1 | 1 | 0 |
                2 | 0 | 1 | 1 | 1 | 1 | 1 | 0 |
                3 | 0 | 0 | 1 | 1 | 1 | 1 | 1 |
                4 | 0 | 0 | 0 | 0 | 1 | 1 | 1 |
                5 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
                6 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
                7 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |

let dp[j][i] denote at stone i, the frog can or cannot make jump of size j




        
dp[n][k] can the frog reach to the n-th stone position(idx of int[] stones) by jumping k units


stones[1] = 1      WIF_currentjump_k = stones[1] - stones[0] = 1  // jump from stones[0]
                        =>  1 == lastjump_k + (-1 ||  0 || 1) 
                        =>  lastjump_k = 0 || 1 || 2

                    dp[1][1] <= dp[0][0] || dp[0][1] || dp[0][2]


stones[2] = 3      WIF_currentjump_k = stones[2] - stones[1] = 2  // jump from stones[1]
                        =>  2 == lastjump_k + (-1 ||  0 || 1) 
                        =>  lastjump_k = 3 || 2 || 1
                    
                    dp[2][2] <= dp[1][3] || dp[1][2] || dp[1][1]
*/