class Solution {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]); 
                num -= values[i];
            }
        }
        return sb.toString();
    }
}

// class Solution {
//     public String intToRoman(int num) {
//         String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};      
//         String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};      
//         String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};   
//         String M[] = {"", "M", "MM", "MMM"};
//         return M[num / 1000] + C[num % 1000 / 100] + X[num % 100 /10] + I[num % 10];
//     }
// }
