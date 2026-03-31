class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return nums;
        int[] list = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int n: nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        for (Integer n: countMap.keySet()) {
            buckets[countMap.get(n)].add(n);
        }

        int idx = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int v: buckets[i]) {
                list[idx++] = v;
                if (idx == k) return list;
            }
        }
        return new int[2];
    }
}
