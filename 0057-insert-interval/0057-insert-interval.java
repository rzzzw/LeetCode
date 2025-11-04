class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(new int[]{newInterval[0], newInterval[1]});

        while(i < intervals.length) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        
        return list.toArray(new int[list.size()][]);
    }
}


// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         List<int[]> list = new ArrayList<>();
//         int i = 0;
//         while (i < intervals.length && intervals[i][1] < newInterval[0]) {
//             list.add(new int[]{intervals[i][0], intervals[i][1]});
//             i++;
//         }
//         while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
//             newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
//             newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
//             i++;
//         }
//         list.add(new int[]{newInterval[0], newInterval[1]});

//         while (i < intervals.length) {
//             list.add(new int[]{intervals[i][0], intervals[i][1]});
//             i++;
//         }

//         int[][] res = new int[list.size()][2];
//         for (int j = 0; j < list.size(); j++) {
//             res[j][0] = list.get(j)[0];
//             res[j][1] = list.get(j)[1];
//         }
//         return res;
//     }
// }