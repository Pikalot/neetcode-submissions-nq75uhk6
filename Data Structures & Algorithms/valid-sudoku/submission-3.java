class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] blocks = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            blocks[i] = new HashSet<Character>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int b = (r/3) * 3 + c/3;
                char ch = board[r][c];
                if (ch == '.') continue;
                if (rows[r].contains(ch) || cols[c].contains(ch) || blocks[b].contains(ch)) {
                    return false;
                }
                rows[r].add(ch);
                cols[c].add(ch);
                blocks[b].add(ch);
            }
        }

        return true;
    }
}
