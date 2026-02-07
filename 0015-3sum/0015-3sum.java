class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if(sum > 0) {
                    right--;
                } else {        // dry run [-2, 0, 0, 0, 2] if feel confused on this part.
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));  
                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // Move to next search window
                    left++;
                    right--;                    
                }
            }
        }
        return res;
    }
}



/* 
[-2, 0, 0, 0, 2]
     ↑        ↑
     left  right


time complexity

        1  2  3  4  5  6  .....
        ^  
       n-1
           ^
          n-2
              .........
              
   (n-1) + (n-2) +...+ 1 = (1+n-1)(n-1)/2 => n^2
            
*/
