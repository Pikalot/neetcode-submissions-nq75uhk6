class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, visited, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, boolean[] visited, int i, List<Integer> path) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (visited[j]) continue;
            path.add(nums[j]);
            visited[j] = true;
            backtrack(list, nums, visited, j + 1, path);
            path.removeLast();
            visited[j] = false;
        }
    }
}
