/**
Min Heap - Maintain a min-heap of size k
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        for (int key : freq.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}



/**
Bucket sort
nums = [1,1,1,2,2,3], k = 2
freq: 
    K: V
    1: 3
    2: 2
    3: 1

bucket: length = 7
    0 1 2 3 4 5 6 
      3 2 1
      

 */

 
// class Solution {
//     private class Item {
//         int key;
//         int val;
        
//         public Item(int key, int val) {
//             this.key = key;
//             this.val = val;
//         }
//     }
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Item> map = new HashMap<>();
//         for (int n : nums) {
//             Item cur = map.get(n);      // 1: null
//             if (cur == null) {
//                 cur = new Item(n, 0);   // Item(1,0) 
//                 map.put(n, cur);        // 1 : (1, 0)
//             }
//             cur.val++;                  // 1 : (1, 1)
//         }
//         Item[] arr = new Item[map.size()];
//         int i = 0;
//         for (Item cur : map.values()) {
//             arr[i++] = cur;
//         }
//         quickSelect(arr, 0, arr.length - 1, k);
//         int[] res = new int[k];
//         for (int j = 0; j < k; j++) {
//             res[j] = arr[j].key;
//         }
//         return res;
//     }
    
//     private void quickSelect(Item[] arr, int lo, int hi, int k) {
//         int randomIndex = (int)(Math.random() * (hi - lo + 1)) + lo;
//         swap(arr, randomIndex, hi);
//         int left = lo;
//         int right = hi - 1;
//         int pivot = arr[hi].val;
//         while (left <= right) {
//             if (arr[left].val <= pivot) { // larger number to the left, smaller number to the right
//                 swap(arr, left, right--);
//             } else {
//                 left++;
//             }            
//         }
//         swap(arr, left, hi);
//         int numOfLargerAndPivot = left - lo + 1;
//         if (numOfLargerAndPivot == k) {
//             return;
//         } else if (numOfLargerAndPivot > k) {
//             quickSelect(arr, lo, left - 1, k);
//         } else {
//             quickSelect(arr, left + 1, hi, k - numOfLargerAndPivot);
//         }
//     }
    
//     private void swap(Item[] arr, int lo, int hi) {
//         Item tmp = arr[lo];
//         arr[lo] = arr[hi];
//         arr[hi] = tmp;
//     }

// }
