class Solution {
    public int findDuplicate(int[] nums) {
        while (nums[0]!= nums[nums[0]]) {
            int nxt = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = nxt;
        }
        return nums[0];
    }
}

/**
example: 
[1,3,4,2,2]

3, 1, 4, 2, 2
2, 1, 4, 3, 2
4, 1, 2, 3, 2
2, 1, 2, 3, 4


example 2:
[3,1,3,4,2]
4, 1, 3, 3, 2
2, 1, 3, 3, 4
3, 1, 2, 3, 4

 */