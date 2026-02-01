// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         Random random = new Random();
//         int[] res = new int[1];
//         getRes(nums, 0, nums.length - 1, k, res, random);
//         return res[0];
//     }

//     private void getRes(int[] arr, int lo, int hi, int k, int[] res, Random random) {
//         int randomIndex = random.nextInt(hi - lo + 1) + lo;
//         swap(arr, randomIndex, hi);
//         int left = lo;
//         int right = hi - 1;
//         while (left <= right) {
//             if (arr[left] > arr[hi]) {
//                 left++;
//             } else {
//                 swap(arr, left, right--);
//             }
//         }
//         swap(arr, left, hi);
//         int countOfLargerAndPivot = left - lo + 1;
//         if (countOfLargerAndPivot == k) {
//             res[0] = arr[left];
//             return;
//         } else if (countOfLargerAndPivot > k) {
//             getRes(arr, lo, left - 1, k, res, random);
//         } else {
//             getRes(arr, left + 1, hi, k - countOfLargerAndPivot, res, random);
//         }
//     }

//     private void swap(int[] arr, int lo, int hi) {
//         int tmp = arr[lo];
//         arr[lo] = arr[hi];
//         arr[hi] = tmp;
//     }
// }


/**
Method 1 : minHeap of size K
Time: O(n log k)
Space: O(k)
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}

