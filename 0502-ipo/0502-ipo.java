
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = profits[i];
            pairs[i][1] = capital[i]; 
        }
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        int i = 0;

        for (int turn = 0; turn < k; turn++) {

            while (i < n && pairs[i][1] <= w) {
                maxHeap.offer(pairs[i][0]);
                i++;
            }

            if (maxHeap.size() == 0) {
                break;
            }

            w += maxHeap.poll();
        }
        return w;
    }
}

/**
k = 2, w = 0
   i 
[1,2,3]
[0,1,1]

w = 1

           3
        2
    
 */