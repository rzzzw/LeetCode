class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] row: reservedSeats) {
            map.put(row[0], map.getOrDefault(row[0], 0) | (1 << (row[1] - 1)));  // seat start from 1， so off by 1
        }  
        int res = 0;
        for (int row : map.keySet()) {
            int number = map.get(row);
                                    //2345                             //6789                                  
            int count = ((number & 0b11110) == 0 ? 1 : 0) + ((number & 0b111100000) == 0 ? 1 : 0); 
                                
                                            //4567
            res += (count == 0 && (number & 0b1111000) == 0) ? 1 : count; 
                // attention: must put "count == 0" as a condition, otherwise it only count 1 instead of 2 for "00 0000 00" scenario
         
        }
        return res + 2 * (n - map.size());                                                         
    }
}

/**
[1,2], [1,3], [1,4] ：

  0b 00 0000 1110 	（seat id： 10 - 1）
    10   〈--   1

bit setter：
    0 | 1 = 1
    number = number | (1 << digit)			1 << 1		10
                                            1 << 3		1000
                                            1 << 4		10000
                                    
map: 
    [1, 2]
         1: 0 | 1 << (2-1)     
      => 1: 0 | 10   
      => 1: 10
      
    [1, 3]  
         1: 10 | 1 << (3-1)  
      => 1: 10 | 100
      => 1: 110
      
    [1, 4]
      => 1: 1110
    
bit getter: how to know the availability of 2345，6789 or 4567 ? how to check "1" or not at certain location
    0b 01 1100 0000   &   0b 01 0000 0000  	= 0b 01 0000 0000   (!= 0 represent that '1' seat is occupied)  
                              ^
                              
    e.g.  to check 6789 => 0b 0111100 000 & __________                       



 */