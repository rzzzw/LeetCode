class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<int[]> res = new ArrayList<>();
        int curStart = 0;
        for (int i = 0; i < start.length; i++) {
            if (i == start.length - 1 || start[i + 1] > end[i]) {
                res.add(new int[]{start[curStart], end[i]});
                curStart = i + 1;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}


/**
            i
start   1   2   8   15
end     3   6   10  18

 */