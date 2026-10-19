class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int i, List<Integer> path) {
        if (res.contains(path)) return;
        res.add(new ArrayList<>(path));

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;
            path.add(nums[j]);
            backtrack(res, nums, j + 1, path);
            path.removeLast();
        }
    }
}
