class Solution {

    private static class Pair{
        int n1;
        int n2;

        Pair(int x, int y) {
            this.n1 = x;
            this.n2 = y;
        }
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Pair[] pairs = new Pair[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }
        // sort by decending of nums2
        Arrays.sort(pairs, (a, b) -> Integer.compare(b.n2, a.n2));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long max = Long.MIN_VALUE;
        for (Pair pair : pairs) {
            sum += pair.n1;
            minHeap.offer(pair.n1);

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                max = Math.max(max, sum * pair.n2);
            }
        }
        return max;
    }
}

