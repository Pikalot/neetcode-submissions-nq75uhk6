class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            // int sum = nums[i] + nums[left] + nums[right];
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                }
                else if (sum > 0) {
                    right--;
                }
                else if (sum == 0) {
                    List<Integer> found = new ArrayList<>();
                    found.add(nums[i]);
                    found.add(nums[left]);
                    found.add(nums[right]);
                    list.add(found);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++; // move next if the sat share the same left and right value;
                    }
                }
            }
        }
        return list;
    }
}
