class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) != '0' ? 1 : 0); 


        for (int i = 2; i <= s.length(); i++) {

            // case1: 1-digit decode
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            } 

            // case2: use 2 digits
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
            
        }
        
        return dp[s.length()];
        
    }
}

/**

prefix DP
dp[i]: number of ways to decode substring s[0..i-1]
dp[i] = number of ways to decode the first i characters

e.g.  
s = 226
注意：idx容易混淆
dp[1] -> way to decode "2"
dp[2] ->  ways to decode "22"
dp[3] ->  ways to decode "226"


s = 226
    0 1 2 3
dp  1 1 2 2

Gut feeling: (WRONG!)
“dp[i-1] already counted dp[i-2], so adding dp[i-2] again seems duplicate.”

dp[i-1] and dp[i-2] represent disjoint sets of decodings once you fix how the last chunk is formed. Even though dp[i-1] numerically includes counts that came from dp[i-2], the final decoded strings are different, so no double counting occurs.

The crucial rule (this is the unlock): 
    DP states are partitioned by their last decision.

----------------------
input: 226
compute dp[3]

Case 1: last chunk = '6'

    take all decodings of "22" and append '6'
    dp[2] = 2

    Decoded strings:
        "2|2" → "B B"
        "22"  → "V"

    Append '6' → 'F':
        "BBF"
        "VF"

    So Case 1 produces:
    { BBF, VF }

Case 2: last chunk = "26"

    take all decodings of "2" and append "26"
    dp[1] = 1

    Decoded strings:
        "B"

    Append "26" → 'Z':
        "BZ"

    So Case 2 produces:
    { BZ }

Final result
Case 1: { BBF, VF }
Case 2: { BZ }

👉 No overlap
👉 No duplicates
👉 Safe to add

Answer to my gut feeling:
Although dp[i-1] was built using dp[i-2], the decodings counted by dp[i-1] and dp[i-2] correspond to different last choices, so they represent disjoint solution sets.

Rule:
If DP transitions correspond to mutually exclusive final decisions, their counts can be safely added.
 */