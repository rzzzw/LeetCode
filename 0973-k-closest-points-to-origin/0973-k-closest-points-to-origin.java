
/**
Each insertion: O(log k)
total: O(n log k)
This is optimal when: k << n
 */



class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0 || k == 0) {
            return null;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> ((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]))
        );
        for (int[] p : points) {
            maxHeap.offer(p);
            // ensure always keep k points, and any point with distance larger than the k in heap, will be polled out. 
            if (maxHeap.size() > k) { 
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}


// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         Arrays.sort(points, (a, b) ->
//             (a[0]*a[0] + a[1]*a[1]) -
//             (b[0]*b[0] + b[1]*b[1])
//         );
//         return Arrays.copyOfRange(points, 0, k);
//     }
// }
// Time: nlogn (Good for interviews if constraints are small.)