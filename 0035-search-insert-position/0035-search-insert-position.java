class Solution{
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/**
Why "<=" not "<"?
  Example:
         0 1
        [5 6]    target: 7
         l r
         m
     
     => "left = mid + 1"
         0 1
        [5 6]    target: 7
           r
           l   
        此时 l == r
        if the condition is l < r only, 此时 l==r 不满足，循环结束，则会漏掉左右指针当前所指的元素。  


 0 1 2 3
[1,3,5,6]
 l m   r
       l/r/m
       
       
 */