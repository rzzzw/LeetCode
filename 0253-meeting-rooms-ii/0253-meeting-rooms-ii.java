/**
The minimum number of rooms needed is the maximum number of overlapping meetings at any time.

Method: Sweep Line

Intuition
1. Every meeting start → +1 room
2. Every meeting end → -1 room
3. Sort events by time
4. Track max simultaneous meetings

Steps
1. Separate start times and end times
2. Sort both
3. Use two pointers:
    If start < end → need room
    Else → free room

My gut feeling tells me I don’t understand this method - “A meeting is a pair (start, end).If I separate them, how do I know which start matches which end? Won’t that mess things up?”

Key realization (THIS is the breakthrough)
I do NOT care which meeting uses which room, I only care about this single number:
What is the maximum number of meetings happening at the same time?

Not:
which room
which meeting overlaps which
which meeting ends first

Just how many are active at any moment

E.g 
    Meetings:
    [0, 30]
    [5, 10]
    [15, 20]

starts = [0, 5, 15]
ends   = [10, 20, 30]

Yes, I lost the pairing
Do I still know when any meeting starts and ends? Yes

What the algorithm ACTUALLY tracks
    use two pointers:
        i → next start
        j → next end

And simulate time flow:

    Timeline walk-through
    Time	Event	    Rooms
    0	    start(0)	1
    5	    start(5)	2
    10	    end(10)	    1
    15	    start(15)	2
    20	    end(20)	    1
    30	    end(30)	    0

    Maximum rooms = 2

 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 1;
        int endIdx = 0;
        for (int i = 1; i < n; i++) {
            if (starts[i] < ends[endIdx]) { // If a meeting starts before the earliest one ends. we need one more room
                res++;
            } else {
                endIdx++;
            }
        }
        return res;
    }
}





/**
Method: Min Heap <-- You always want to know which meeting ends the earliest, so you can reuse that room ASAP.

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

Time: O(NlogN)
Space: O(N)
 */

// class Solution {
//     public int minMeetingRooms(int[][] intervals) {
//         if (intervals == null || intervals.length == 0) {
//             return 0;
//         }
//         // 1. Sort by start time
//         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

//         // 2. minHeap of end times
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();

//         for (int[] meeting : intervals) {
//             int start = meeting[0];
//             int end = meeting[1];

//             // 3. reuse room if possible
//             if (!minHeap.isEmpty() && start >= minHeap.peek()) {
//                 minHeap.poll();
//             }

//             // 4. Allocate room
//             minHeap.offer(end);
//         }

//         return minHeap.size();
//     }
// }
