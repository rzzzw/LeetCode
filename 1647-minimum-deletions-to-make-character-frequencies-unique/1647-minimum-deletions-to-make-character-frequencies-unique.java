class Solution {
    public int minDeletions(String s) {
        int[][] map = new int[26][2];
        int x = 0;
        for (int i = 0; i < map.length; i++) {
            map[i][0] = x;
            x++; 
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i] - 'a';
            map[temp][1]++; 
        }
        Arrays.sort(map, (a, b) -> a[1] - b[1]);
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < map.length; i++) {
            if (map[i][1] == 0) continue;
            while (map[i][1] > 0 && set.contains(map[i][1])) {
                map[i][1]--;
                res++;
            }
            set.add(map[i][1]);
        }
        return res;
    }
}

// aaaabbccccdddddd
// step 1: map -> count
//      0 1 2 3  
//      4 2 4 6

// step 2: Arrays.sort
//      1 0 2 3  
//      2 4 4 6

// step 3: check duplicate qty -> iterate with minus operation

//      1 0 2 3 4 5
//      2 4 4 5 5 6

//     4 1 2 0 3  5
//     1 2 3 4 5  6
