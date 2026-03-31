class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] squares = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            squares[i] = new HashSet<Character>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int sqrIndex = (r/3)*3 + c/3;

                if (board[r][c] == '.') continue;
                if (rows[r].contains(board[r][c]) ||
                    cols[c].contains(board[r][c]) ||
                    squares[sqrIndex].contains(board[r][c]))
                    return false;
                
                rows[r].add(board[r][c]);
                cols[c].add(board[r][c]);
                squares[sqrIndex].add(board[r][c]);
            }
        }
        return true;
    }
}
