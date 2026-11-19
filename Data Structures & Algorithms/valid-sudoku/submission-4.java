class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int b = (i / 3) * 3 + (j / 3);
                if (board[i][j] == '.') continue;

                if (
                    rows[i].contains(board[i][j]) ||
                    cols[j].contains(board[i][j]) ||
                    boxes[b].contains(board[i][j]))
                    return false;

                rows[i].add(board[i][j]);
                cols[j].add(board[i][j]);
                boxes[b].add(board[i][j]);
            } 
        }
        return true;
    }
}
