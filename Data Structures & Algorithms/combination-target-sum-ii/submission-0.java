class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, candidates, target, 0, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(List<List<Integer>> list, int[] candidates, int target, int sum, int i, List<Integer> path) {
        if (sum == target) {
            list.add(new ArrayList<>(path));
            return;
        }

        if (sum > target) return;

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            path.add(candidates[j]);
            backtrack(list, candidates, target, sum + candidates[j], j + 1, path);
            path.removeLast();
        }
    }
}
