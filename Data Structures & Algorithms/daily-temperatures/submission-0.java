class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for (int i = temperatures.length - 2; i >= 0; i--) {
            // int count = 0;
            int j = i + 1;
            while (j < temperatures.length && temperatures[j] <= temperatures[i]) {
                if (result[j] == 0) {
                    j = temperatures.length;
                    break;
                }
                j += result[j];
            }
            if (j < temperatures.length) {
                result[i] = j - i;
            }
        }
        return result;
    }
}
