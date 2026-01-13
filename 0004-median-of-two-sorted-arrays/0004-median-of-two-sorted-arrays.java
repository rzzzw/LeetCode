class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        if (total % 2 == 1) {
            int kth = (total + 1) / 2;
            return findKth(nums1, 0, nums2, 0, kth);
        } else {
            int leftK = total / 2;
            int rightK = leftK + 1;
            double leftVal = findKth(nums1, 0, nums2, 0, leftK);
            double rightVal = findKth(nums1, 0, nums2, 0, rightK);
            return (leftVal + rightVal) / 2.0;
        }
    }

    private double findKth(int[] A, int i, int[] B, int j, int k) {
        // if A is exhausted, k-th is in B
        if (i >= A.length) {
            return B[j + k - 1];
        }
        // if B is exhausted, k-th is in A
        if (j >= B.length) {
            return A[i + k - 1];
        }
        // If k == 1, it's minimum of current heads
        if (k == 1) {
            return Math.min(A[i], B[j]);
        }

        int half = k / 2;
        int newIdxA = i + half - 1;
        int newIdxB = j + half - 1;

        int valA = newIdxA < A.length ? A[newIdxA] : Integer.MAX_VALUE;
        int valB = newIdxB < B.length ? B[newIdxB] : Integer.MAX_VALUE;

        if (valA < valB) {
            return findKth(A, i + half, B, j, k - half);
        } else {
            return findKth(A, i, B, j + half, k - half);
        }
    }

}

/**
Time: O(log (m+n))
Space: O(log (m+n))

 */