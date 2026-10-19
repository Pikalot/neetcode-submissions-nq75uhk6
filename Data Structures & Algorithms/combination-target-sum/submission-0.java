class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, nums, target, 0, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, int target, int i, int sum, List<Integer> path) {
        if (sum == target) {
            list.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) return;

        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            backtrack(list, nums, target, j, sum + nums[j], path);
            path.removeLast();
        }
    }
}
