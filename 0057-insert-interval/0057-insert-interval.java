class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && newInterval[0] > intervals[i][1]) {
            res.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        while(i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(new int[]{newInterval[0], newInterval[1]});

        while(i < intervals.length) {
            res.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}

