/**
Key Insight
    If one number appears more than half the time, then:
        It cannot be fully canceled out by all other numbers combined.

Cancellation Idea
    Imagine pairing different numbers and canceling them.
    Since the majority element appears more than n/2 times:
    Even if every other element cancels one majority, there will still be majority elements left.

 */

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; 
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            if (n == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}

