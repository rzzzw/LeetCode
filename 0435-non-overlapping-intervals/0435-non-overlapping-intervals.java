class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1])); 
        int res = 0;
        int k = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            if (x >= k) {
                k = y;
            } else {
                res++;
            }
        }
        return res;
    }
}


/**
        1   2   3   4   5   
        ____
            ____
        ________
                ____

 */