class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0, b = matrix.length - 1;

        while (t <= b) {
            int rM = (t + b) / 2;
            int rLength = matrix[rM].length;
            int vL = matrix[rM][0];
            int vR = matrix[rM][rLength - 1];
            if (vL == target || vR == target) return true;
            
            // target in the row
            if (vL < target && target < vR) {
                int l = 0, r = rLength - 1;

                while (l <= r) {
                    int cM = (l + r) / 2;
                    if (matrix[rM][cM] == target) return true;
                    if (matrix[rM][cM] < target) l = cM + 1;
                    else r = cM - 1;
                }
                return false;
            }
            else if (vL > target) b = rM - 1;
            else if (vR < target) t = rM + 1;
        }

        return false;
    }
}
