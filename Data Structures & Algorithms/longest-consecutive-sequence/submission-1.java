class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int n: nums) {
            set.add(n);
        }

        for (int n: nums) {
            if (!set.contains(n - 1)) {
                int length = 0;
                while (set.contains(n + length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;

    }
}
