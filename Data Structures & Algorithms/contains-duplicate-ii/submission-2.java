// input    1   2   3   1   |   k = 3
//                      i
// window   1   2   3   1   |   l = k + 1 = 4
// output   T

// input    2   1   2   |   k = 1
//                  i
// set          1   2    |   l = 2
// output   F

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