/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> all = new ArrayList<>();

        // Step 1: flatten
        for (List<Interval> emp : schedule) {
            all.addAll(emp);
        }

        // Step 2: sort
        Collections.sort(all, (a, b) -> a.start - b.start);

        List<Interval> res = new ArrayList<>();

        // Step 3: merge + find gaps
        int end = all.get(0).end;

        for (int i = 1; i < all.size(); i++) {
            Interval cur = all.get(i);

            if (cur.start > end) {
                // gap found
                res.add(new Interval(end, cur.start));
                end = cur.end;
            } else {
                end = Math.max(end, cur.end);
            }
        }
        return res;
        
    }
}