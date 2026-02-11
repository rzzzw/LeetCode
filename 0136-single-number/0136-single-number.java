/**
Key Insight: XOR

Property 1: a ^ a = 0
Property 2: a ^ 0 = a
Property 3: XOR is commutative and associative: a ^ b ^ a = b


[4,1,2,1,2]
4 ^ 1 ^ 2 ^ 1 ^ 2
4 ^ (1 ^ 1) ^ (2 ^ 2)
4 ^ 0 ^ 0
4
 */

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}
