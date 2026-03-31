class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return nums;
        int[] result = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer>[] bucketSort = new ArrayList[nums.length + 1];
        for (int i = 0; i < bucketSort.length; i++) {
            bucketSort[i] = new ArrayList<>();
        }

        // Count and save to map
        for (int key: nums) {
            if (!countMap.containsKey(key)) {
                countMap.put(key, 0);
            }
            int count = countMap.get(key);
            countMap.put(key, ++count);
        }

        // Sort by bucket sort
        for (int value: countMap.keySet()) {
            int index = countMap.get(value);
            bucketSort[index].add(value);
        }

        // Get k elements
        int resIndex = 0;
        for (int i = bucketSort.length - 1; i >= 0 && resIndex < k; i--) {
            for (int value: bucketSort[i]) {
                result[resIndex++] = value;
            }
        }
        return result;
    }
}
