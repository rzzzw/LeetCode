// class Solution {
//     public int minMeetingRooms(int[][] intervals) {
//         int n = intervals.length;
//         int[] starts = new int[n];
//         int[] ends = new int[n];
//         for (int i = 0; i < n; i++) {
//             starts[i] = intervals[i][0];
//             ends[i] = intervals[i][1];
//         }
//         Arrays.sort(starts);
//         Arrays.sort(ends);
//         int res = 1;
//         int endIdx = 0;
//         for (int i = 1; i < n; i++) {
//             if (starts[i] < ends[endIdx]) {
//                 res++;    
//             } else {
//                 endIdx++;
//             }
//         }
//         return res;
//     }
// }


/**
The minimum number of rooms needed is the maximum number of overlapping meetings at any time.

Method1: Min Heap <-- You always want to know which meeting ends the earliest, so you can reuse that room ASAP.

Intuition
1. Sort meetings by start time
2. Use a min heap to track earliest ending meeting
3. If a meeting starts after the earliest one ends → reuse room
4. Otherwise → need a new room

Step-by-step logic
1. Sort intervals by start
2. Create a min heap that stores end times
3. For each meeting:
    If start >= heap.peek() → room is free → pop
    Push current end
4. Heap size = number of rooms in use
5. Max heap size encountered = answer

[0, 30]
[5, 10]
[15, 20]    

                [5, 10]
            [0, 30]
 */

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 1. Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 2. minHeap of end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] meeting : intervals) {
            int start = meeting[0];
            int end = meeting[1];

            // 3. reuse room if possible
            if (!minHeap.isEmpty() && start >= minHeap.peek()) {
                minHeap.poll();
            }

            // 4. Allocate room
            minHeap.offer(end);
        }

        return minHeap.size();
    }
}
