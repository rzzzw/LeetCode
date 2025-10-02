class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumExpected = (1 + n) * n / 2;
        int sumActual = 0;
        for (int num : nums) {
            sumActual += num;
        }

        return sumExpected - sumActual;
    }
}

    // public int missingNumber(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     int[] map = new int[nums.length + 1];
    //     for (int num : nums) {
    //         map[num]++;
    //     }
    //     for (int i = 0; i < map.length; i++) {
    //         if (map[i] == 0) {
    //             return i;
    //         }
    //     }
    //     return nums.length;
    // }