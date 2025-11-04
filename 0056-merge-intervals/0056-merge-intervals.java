class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < starts.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<int[]> list = new ArrayList<>();
        int indexS = 0;
        for (int i = 0; i < starts.length; i++) {
            if (i == ends.length - 1 || starts[i + 1] > ends[i]) {
                list.add(new int[] {starts[indexS], ends[i]});
                indexS = i + 1;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}