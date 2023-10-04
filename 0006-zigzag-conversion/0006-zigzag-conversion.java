class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1 || numRows >= s.length()) {
            return s;
        }
        int n = s.length();
        int numCols =(int)Math.ceil(n / (numRows + (numRows - 2.0))) * (numRows - 1);

        char[][] arr = new char[numRows][numCols];
        
        int curRow = 0; 
        int curCol = 0;
        int stringIdx = 0;
        while (stringIdx < n) {
            while (curRow < numRows && stringIdx < n) {
                arr[curRow][curCol] = s.charAt(stringIdx);
                curRow++;
                stringIdx++;
            }
            
            curRow -= 2;
            curCol++;
            
            while (curRow > 0 && curCol < numCols && stringIdx < n) {
                arr[curRow][curCol] = s.charAt(stringIdx);
                curRow--;
                curCol++;
                stringIdx++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char[] row : arr) {
            for (char ch : row) {
                if (ch != '\0') {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
        
    }
}