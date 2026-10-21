/**
        1   2   3
        i   bt  bt
        i   i   bt
        bt  bt  bt   
path 1
list    123 
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, visited, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, boolean[] visited, int i, List<Integer> set) {
        if (set.size() == nums.length) {
            list.add(new ArrayList<>(set));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (visited[j]) continue;

            visited[j] = true;
            set.add(nums[j]);
            backtrack(list, nums, visited, j + 1, set);
            visited[j] = false;
            set.removeLast();
        }
    }
}
