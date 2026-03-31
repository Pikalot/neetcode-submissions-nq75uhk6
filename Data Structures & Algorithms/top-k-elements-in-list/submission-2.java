class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int n: nums) {
            if (!map.containsKey(n)) map.put(n, 0);
            int count = map.get(n);
            map.put(n, ++count);
        }

        for (int value: map.keySet()) {
            int index = map.get(value);
            buckets[index].add(value);
        }

        int rIndex = 0;
        for (int i = buckets.length - 1; i >= 0 && rIndex < k; i--) {
            for (int n: buckets[i]) {
                result[rIndex++] = n;
            }
        }
        return result;
    }
}
