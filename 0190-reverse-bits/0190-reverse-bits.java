class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>>= 1;
        }
        return res;
    }
}

/**
n = 1101   (we want to reverse → 1011)
result = 0

Step 1:
  result = (0 << 1) | (1101 & 1)
          = 0 | 1 = 1
  n >>= 1 → 110

Step 2:
  result = (1 << 1) | (110 & 1)
          = (10) | 0 = 10
  n >>= 1 → 11

Step 3:
  result = (10 << 1) | (11 & 1)
          = (100) | 1 = 101
  n >>= 1 → 1

Step 4:
  result = (101 << 1) | (1 & 1)
          = (1010) | 1 = 1011

 */