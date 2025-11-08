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

“Shift first to make room, then add the new bit. Never shift after the last one.”

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


why need "res << 1" first then copy the last bit of n into it? why not copy first and shift?

At the very beginning,
result = 0000...0000,
so doing result << 1 changes nothing — it’s still all zeros.
That’s why the first “shift” in

result = (result << 1) | (n & 1);


is harmless and just sets up space for the incoming bit.

But at the end, once you’ve collected all bits,
an extra shift (like in your modified version) would push the entire reversed number one position too far to the left — effectively dropping the highest bit and adding a 0 at the end.

That’s what makes the result wrong.


 */