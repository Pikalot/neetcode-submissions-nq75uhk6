class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rUp = 0;
        int rBottom = matrix.length - 1;
        int cLeft = 0;
        int cRight = matrix[0].length - 1;

        while (rUp <= rBottom) {
            int rMid = (rUp + rBottom) / 2;
            if (matrix[rMid][0] == target) return true;
            else if (matrix[rMid][0] > target) rBottom--;
            else rUp++;
        }
        // If cannot found, target should be int the bottom rows

        if (rBottom < 0) return false;

        while (cLeft <= cRight) {
            int cMid = (cLeft + cRight) / 2;

            if (matrix[rBottom][cMid] == target) return true;
            else if (matrix[rBottom][cMid] > target) cRight--;
            else cLeft++;
        }

        return false;
    }
}
