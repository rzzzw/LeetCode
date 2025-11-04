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


/**
            i
start   1   2   8   15
end     3   6   10  18

 */

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // Step 1. Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merge = new ArrayList<>();

        // Step 2. Iterate through the sorted intervals
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            // Overlapping condition            
            if (cur[1] >= next[0]) {
                // Merge by extending the end boundary
                cur[1] = Math.max(cur[1], next[1]);
            } else {
                merge.add(cur);
                cur = next;
            }
        }
        // Don’t forget the last one
        merge.add(cur);
        return merge.toArray(new int[merge.size()][]);
    }
}



//  class Solution {
//     public int[][] merge(int[][] intervals) {
//         if (intervals.length <= 1) {
//             return intervals;
//         }

//         // Step 1. Sort intervals by their start time
//         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

//         List<int[]> merged = new ArrayList<>();

//         // Step 2. Iterate through the sorted intervals
//         int[] current = intervals[0];
//         for (int i = 1; i < intervals.length; i++) {
//             int[] next = intervals[i];
//             // Overlapping condition
//             if (next[0] <= current[1]) {
//                 // Merge by extending the end boundary
//                 current[1] = Math.max(current[1], next[1]);
//             } else {
//                 // No overlap → add the previous one to result
//                 merged.add(current);
//                 current = next; // move on
//             }
//         }

//         // Don’t forget the last one
//         merged.add(current);

//         return merged.toArray(new int[merged.size()][]);
//     }
// }