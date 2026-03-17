/**
Key Insight 
    Two intervals overlap if: current.start <= previous.end

Sorting: O(n log n)
Merging: O(n)
Total: O(n log n)

Space: O(n) for result
 */


class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(intervals[i][1], cur[1]);
            } else {
                res.add(cur);
                cur = intervals[i];
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);       
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

