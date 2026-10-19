class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, new ArrayList<Integer>());

        return res;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, int i, List<Integer> path) {
        list.add(new ArrayList<>(path));

        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            backtrack(list, nums, j + 1, path);
            path.removeLast();
        }
    }
}
