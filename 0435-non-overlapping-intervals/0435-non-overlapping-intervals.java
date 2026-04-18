class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                res++;
            } else {
                end = intervals[i][1];
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


        1   2   3   4   5   
        ____
        ________        
            ____
                ____
 */