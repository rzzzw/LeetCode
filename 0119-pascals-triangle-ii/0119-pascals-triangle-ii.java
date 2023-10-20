class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
            res.add(1);
        }
        return res;
    }
}



/**
rowIndex
        0:  1                       
        1:  1 1                     
        2:  1 2 1                   
        3:  1 3 3 1                 
        4:  1 4 6 4 1               
        5:  1 5 10 10 5 1           
        6:  1 6 15 20 15 6 1

      *
0 1 2 3 4 5 6 
1 1
1 2 1
1 3 3 1
... 
        
 */