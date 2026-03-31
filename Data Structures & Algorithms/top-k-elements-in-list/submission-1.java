class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> buckets[] = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        int[] result = new int[k];
        for (int num: nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            int count = map.get(num);
            map.put(num, ++count);
        }
        for (int key : map.keySet()) {
            int index = map.get(key);
            buckets[index].add(key);
        }
        int stop = 0;
        for (int i = buckets.length - 1; i >= 0 && stop < k; i--) {
            for (int n: buckets[i]) {
                result[stop++] = n;
                if (stop == k) return result;
            }
        }
        return result;
    }
}
