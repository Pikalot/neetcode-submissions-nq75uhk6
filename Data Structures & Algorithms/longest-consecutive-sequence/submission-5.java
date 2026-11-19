class Solution {
    public int longestConsecutive(int[] nums) {
        int count = 0;
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        for (int n : set) {
            if (!set.contains(n - 1)) {
                int l = 0;
                while (set.contains(n + l)) {
                    l++;
                }
                count = Math.max(l, count);
            }
        }

        return count;
    }
}
