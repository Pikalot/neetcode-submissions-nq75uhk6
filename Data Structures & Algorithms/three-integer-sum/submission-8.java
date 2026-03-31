class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int left = nums[l];
                int right = nums[r];
                int sum = nums[i] + left + right;
                if (sum == 0) {
                    list.add(new ArrayList(List.of(nums[i], left, right)));
                    while (nums[l] == left && l < nums.length - 1) l++;
                    while (nums[r] == right && r > 0) r--;
                }
                else if (sum < 0) l++;
                else r--;
            }
        }

        return list;
    }
}
