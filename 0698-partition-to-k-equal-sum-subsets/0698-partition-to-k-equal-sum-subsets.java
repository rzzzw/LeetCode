class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        
        return dfs(nums, k, sum/k, 0, new boolean[nums.length], sum/k);      
    }
    
    private boolean dfs(int[] nums, int k, int remain, int index, boolean[] visited, int target) {    
        if (k == 1) {
            return true;
        }
        if (remain == 0) {
            remain = target;
            index = 0;
            if (dfs(nums, k - 1, remain, index, visited, target)) {
                return true;
            }
            return false;
        }
        
        for (int i = index; i < nums.length; i++) {
            if(!visited[i] && remain >= nums[i]) {
                visited[i] = true;
                if (dfs(nums, k, remain - nums[i], i + 1, visited, target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
        
    }
}

/*
                                                     [          ]

                                          /         /         \         \             

                         4, 0, 0, 0
                         
                  /      /       \       \   
                  
          7,0,0,0        



*/