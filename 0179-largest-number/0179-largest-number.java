class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {     
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}



/**
[3,30,34,5,9]
330 > 303 => 3 > 30
334 < 343 => 34 > 3 => 34 > 3 > 30
534 > 345 => 5 > 34 => 5 > 34 > 3 > 30
95 > 59 => 9 > 5 => 9 > 5 > 34 > 3 > 30


 */