class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else {
                j++;
            }
        }
        return;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}

/**
i, j, k

[0, i): a
[i, j): b
[j, k]: unknown
(k, n-1]: c 


0, 2, 0, 2, 1, 1, 0
   i
   j
                  k



 */