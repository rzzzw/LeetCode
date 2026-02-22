class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;        
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }
}

// class Solution {
//     public String addBinary(String a, String b) {
//         if (a.length() < b.length()) {
//             return addBinary(b, a);
//         }
//         StringBuilder sb = new StringBuilder();
//         int carry = 0;
//         int j = b.length() - 1;
//         for (int i = a.length() - 1; i >= 0; i--) { // length of a should >= length of b
//             if (a.charAt(i) == '1') {
//                 carry++;
//             }
//             if (j >= 0 && b.charAt(j--) == '1') { // 注意这里 j-- 的写法
//                 carry++;
//                 // j--; this is wrong 无论是否等于1 j都要--
//             }
//             if (carry % 2 == 1) {
//                 sb.append('1');
//             } else {
//                 sb.append('0');
//             }
//             carry /= 2;
//         }
//         if (carry == 1) {
//             sb.append('1');
//         }
//         sb.reverse();
//         return sb.toString();
//     }
// }

