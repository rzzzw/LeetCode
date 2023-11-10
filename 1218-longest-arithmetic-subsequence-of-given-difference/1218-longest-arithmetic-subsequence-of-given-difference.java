class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;
        for (int a : arr) {
            int desiredPreCount = map.getOrDefault(a - difference, 0);
            map.put(a, desiredPreCount + 1);
            res = Math.max(res, map.get(a));
        }
        return res;
    }
}

/**
            0 1 2
            1 5 7 8 5 3 4 2 1      
            1 1 1 


            0 1 2 3
            1 2 3 4
        dp. 1 2 3 4

map: 1, 1
     2, 2
     3, 3
     4, 4


 */