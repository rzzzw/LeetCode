/**
Key Insight 
    Two intervals overlap if: current.start <= previous.end
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                result.add(cur);
                cur = intervals[i];
            }
        }
        result.add(cur);
        return result.toArray(new int[result.size()][]);
    }
}
// class Solution {
//     public int[][] merge(int[][] intervals) {
//         if (intervals == null || intervals.length == 1) {
//             return intervals;
//         }
//         int[] start = new int[intervals.length];
//         int[] end = new int[intervals.length];
//         for (int i = 0; i < intervals.length; i++) {
//             start[i] = intervals[i][0];
//             end[i] = intervals[i][1];
//         }
//         Arrays.sort(start);
//         Arrays.sort(end);
//         List<int[]> res = new ArrayList<>();
//         int curStart = 0;
//         for (int i = 0; i < start.length; i++) {
//             if (i == start.length - 1 || start[i + 1] > end[i]) {
//                 res.add(new int[]{start[curStart], end[i]});
//                 curStart = i + 1;
//             }
//         }
//         return res.toArray(new int[res.size()][]);
//     }
// }

