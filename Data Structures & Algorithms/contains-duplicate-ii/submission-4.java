class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        if (length < 2 || k == 0) return false;
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < length; i++) {
            if (!window.isEmpty() && window.contains(nums[i])) return true;
            window.add(nums[i]);

            if (i >= k) {
                int l = i - k;
                window.remove(nums[l]);
            }
        }
        return false;
    }
}