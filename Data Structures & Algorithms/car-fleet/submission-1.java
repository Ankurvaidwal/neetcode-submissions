class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        Integer[] idx = new Integer[position.length];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> Integer.compare(position[b], position[a]));

        double previousTime = 0;
        int fleets = 0;

        for (int i : idx) {
            double time = (target - position[i]) / (double) speed[i];

            if (time > previousTime) {
                fleets++;
                previousTime = time;
            }
        }

        return fleets;
    }
}
