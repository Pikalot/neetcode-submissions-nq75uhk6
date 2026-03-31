class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> fleets = new Stack<>();
        int[][] pair = new int[position.length][2];

        for (int i = 0; i < pair.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        for (int[] p: pair) {
            double time = (double) (target - p[0]) / p[1];
            if (fleets.isEmpty() || time > fleets.peek()) {
                fleets.push(time);
            }
        }
        return fleets.size();
    }
}
