// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> res = new ArrayList<>();
//         if (n == 0) {
//             return res;
//         }
//         List<Integer> path = new ArrayList<>();
//         helper(path, res, n);
//         return res;
//     }
//     private void helper(List<Integer> path, List<List<String>> res, int n) {
//         if (path.size() == n) {
//             List<String> pathString = convertPath(path);
//             res.add(new ArrayList(pathString));
//         }
//         for (int i = 0; i < n; i++) { // this n represent the range of vertical axis(y-axis)
//             if (isValid(path, i)) {
//                 path.add(i);
//                 helper(path, res, n);
//                 path.remove(path.size() - 1);
//             }
//         }
//     }

//     private boolean isValid(List<Integer> path, int y) {
//         int x = path.size();
//         for (int i = 0; i < x; i++) {
//             if (path.get(i) == y || Math.abs(path.get(i) - y) == x - i) { // slop:  -1 || 1
//                                          //e.g.: [1, 2, 3, 4] or [2, 3, 4, 1]
//                 return false;
//             }
//         }
//         return true;
//     }

//     private List<String> convertPath(List<Integer> path) {
//         List<String> pathString = new ArrayList<>();
//         for (int i = 0; i < path.size(); i++) {
//             StringBuilder sb = new StringBuilder();
//             for (int j = 0; j < path.size(); j++) {
//                 if (j == path.get(i)) {
//                     sb.append('Q');
//                 } else {
//                     sb.append('.');
//                 }
//             }
//             pathString.add(sb.toString());
//         }
//         return pathString;
//     }
// }


class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        helper(n, path, res);
        return res;
    }

    private void helper(int n, List<Integer> path, List<List<String>> res) {
        if (path.size() == n) {
            List<String> pathString = convertPath(path);
            res.add(new ArrayList<>(pathString));
        }
        for (int i = 0; i < n; i++) {
            if (isValid(path, i)) {
                path.add(i);
                helper(n, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> path, int y) {
        int x = path.size(); // x: the current x-axis; y: the current y-axis => (x, y)
        for(int i = 0; i < x; i++) {
            if (path.get(i) == y || Math.abs(y - path.get(i)) == x - i) { // slop:  -1 || 1   
                                            // y - y1 == x - x1 
                                            // path: [1, 2, ..]                                   
                                            //         o x o o (0, 1)
                                            //         o o x o (1, 2)
  
                return false;
            }
        }
        return true;
    }

    private List<String> convertPath(List<Integer> path) {
        List<String> pathString = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < path.size(); j++) {
                if (j == path.get(i)) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            pathString.add(sb.toString());
        }
        return pathString;
    }    
}