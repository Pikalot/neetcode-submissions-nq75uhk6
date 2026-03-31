class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rUp = 0, rBot = matrix.length - 1;

        while (rUp <= rBot) {
            int rMid = (rUp + rBot) / 2;
            int vLeft = matrix[rMid][0], vRight = matrix[rMid][matrix[rMid].length - 1];

            if (vLeft <= target && target <= vRight) {
                // BinSearch
                int cLeft = 0, cRight = matrix[rMid].length - 1;
                
                while (cLeft <= cRight) {
                    int cMid = (cLeft + cRight) / 2;
                    int val = matrix[rMid][cMid];

                    if (val == target) return true;
                    else if (val > target) cRight = cMid - 1;
                    else cLeft = cMid + 1;
                }
                return false;
            }
            else if (vLeft > target) rBot = rMid - 1;
            else if (vRight < target) rUp = rMid + 1;
        }

        return false;
    }
}
