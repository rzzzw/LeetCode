class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // dp[2] = 2;

        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }
        
        for (int i = 1; i <= n; i++) { // root from 1 ~ n
            dp[n] += helper(i - 1, dp) * helper(n - i, dp);
        }
        return dp[n];
    }
}

/**

WIF input = 5
    output = root(1) + root(2) + root(3) + root(4) + root(5)
    
            root(1)                  root(2)               root(3)               root(4)            root(5)
            /      \                 /      \              /      \              /      \           /      \
        0 Node     4 Node       1 Node      3 Node     2 Node     2 Node    3 Node     1 Node    4 Node    0 Node
        left sub   right sub    


             root(1) 
            /      \
      0 Node        4 Node
      ~~~~~~~       ~~~~~~~~~  
    null => 1       Output = root(2) + root(3) + root(4) + root(5)

                    root(2)
                /           \
            0 Node        3 Node
            ~~~~~~~       ~~~~~~~~~  
          null => 1       Output = root(3) + root(4) + root(5)

                                root(3)
                            /           \
                        0 Node        2 Node
                        ~~~~~~~       ~~~~~~~~~  
                      null => 1       Output = root(4) + root(5)
                                                ~~~~~~~~~~~~~~ 2 nodes has only 2 options 
                                                4            5
                                                 \    or    /
                                                  5        4

Base case:
    subtree 0 node -> 1 unique structure
    subtree 1 node -> 1 unique structure
    subtree 2 nodes -> 2 unique structures

Recursion rule:
    root node = # of left subtree * # of right subtree


Visualized examples -> input 5, all structures with root = 1:
                                                                                           
 
            1                1                     1                        1                       1             |                  
        /       \         /     \              /       \                /      \                 /     \          |         
    null         2     null      2          null        2             null       2             null     2         |   
               /   \               \                  /    \                   /   \                  /    \      |    
           null     3               3             null     4                null     5             null     5     |             
                  /   \               \                  /   \                     /                       /      |                  
              null     4               5                3     5                   3                      4        |                               
                      /  \            /                                             \                   /         |                          
                  null    5          4                                               4                 3          |        


                                        
            1             1           
        /     \         /    \       
      null     3     null     3    
             /   \          /  \        
            2     4        2    5        
                   \           /          
                    5         4             
                                     
                                   

            1                 1               1              1               1              1            1
         /     \            /    \         /      \      /       \       /       \      /       \     /       \
       null     4       null      4      null      5    null      5   null       5    null       5  null       5 
             /    \            /    \            /              /                /               /             /
            2      5          3      5         2               2                3               4             4
             \               /                  \               \             /   \            /             /
              3             2                     3               4          2     4          2             3
                                                   \             /                             \           /
                                                    4           3                               3         2                                              

 */