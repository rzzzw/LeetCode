class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int res = 0;
        int i = 0;
        for (int k = 0; k < buses.length; k++) {
            int count = 0;
            while (count < capacity && i < passengers.length && passengers[i] <= buses[k]) {
                if (i == 0 || (i - 1 >= 0 && passengers[i] - 1 != passengers[i - 1])) {
                    res = passengers[i] - 1;
                }
                i++;
                count++;
            }
            if (count < capacity) {
                if (i == 0 || (i - 1 >= 0 && passengers[i - 1] != buses[k])) {
                    res = buses[k];
                }
            }
        }
        return res;
    }
}

