
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        // decende the pairs based on pairs[i][1] (nums2)
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += pairs[i][0];
            minHeap.offer(pairs[i][0]);

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                max = Math.max(max, sum * pairs[i][1]);
            }
        }
        return max;
    }
}

// class Solution {

//     private static class Pair{
//         int n1;
//         int n2;

//         Pair(int x, int y) {
//             this.n1 = x;
//             this.n2 = y;
//         }
//     }
//     public long maxScore(int[] nums1, int[] nums2, int k) {
//         Pair[] pairs = new Pair[nums1.length];
//         for (int i = 0; i < nums1.length; i++) {
//             pairs[i] = new Pair(nums1[i], nums2[i]);
//         }
//         // sort by decending of nums2
//         Arrays.sort(pairs, (a, b) -> Integer.compare(b.n2, a.n2));

//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//         long sum = 0;
//         long max = Long.MIN_VALUE;
//         for (Pair pair : pairs) {
//             sum += pair.n1;
//             minHeap.offer(pair.n1);

//             if (minHeap.size() > k) {
//                 sum -= minHeap.poll();
//             }

//             if (minHeap.size() == k) {
//                 max = Math.max(max, sum * pair.n2);
//             }
//         }
//         return max;
//     }
// }

