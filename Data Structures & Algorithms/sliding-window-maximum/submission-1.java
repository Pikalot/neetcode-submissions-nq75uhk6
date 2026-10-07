/**
        1   2   1   0   4   2   6
                        l
                                r
                                m
heap    6:6     4:4     1:2     0:3     2:5
max     6
res     2   2   4   4   6
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int r = 0; r < nums.length; r++) {
            maxHeap.offer(new int[] {nums[r], r});

            if (r - l + 1 == k) {
                while (maxHeap.peek()[1] < l) maxHeap.poll();

                list.add(maxHeap.peek()[0]);
                l++;
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}
