class Solution {
    public long minimumReplacement(int[] nums) {
        long res = 0;
        int n = nums.length;
        
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i+1]) {
                continue;
            }
            
            long subElements = (long)(nums[i] + nums[i + 1] - 1) /  (long)nums[i + 1];  
            /*
            Why "nums[i] + nums[i + 1] - 1" ?
            
            3 9 3                           3 8 3
              ^   9/3 = 3 is ok     but       ^    8/3 = 2 will miss 1 step of split
            
            so nums[i] + nums[i + 1], and to prevent overcount in divisible case like "(9+3)/3=4" => "(9+3-1)/3=3"
            */
            
            res += subElements - 1;
            nums[i] = nums[i] / (int)subElements; // The largest possible nums[i] after the operations
            /*

            3    7     3
                 ^
                 2 2 3 3        
                 -----
                 ^
                new nums[i]  =>  what's the largest nums[i] could be?      

              given 7 will be split to 3 subElements 

                    1 3 3 or 2 2 3 ?  maximum nums[i] must be 2 2 3
                                                              ^
                                                             7/3

            */            
        }
        return res;
    }
}
