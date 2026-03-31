class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pMap = new int[position.length][2];
        Stack<Double> fleets = new Stack<>();

        for (int i = 0; i < position.length; i++) {
            pMap[i][0] = position[i];
            pMap[i][1] = speed[i];
        }
        
        Arrays.sort(pMap, (a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < pMap.length; i++) {
            double time = (double) (target - pMap[i][0]) / pMap[i][1];
            if (fleets.isEmpty() || fleets.peek() < time) {
                fleets.push(time);
            }
        }

        return fleets.size();
    }
}
