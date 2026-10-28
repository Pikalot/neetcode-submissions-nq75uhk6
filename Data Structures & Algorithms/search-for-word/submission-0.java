/**
    A   B   C   E
    i   i   bt
    S   F   C   S
    bt  bt
    A   D   E   E


path AB
 */


class Solution {
    boolean flag = false;
    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) backtrack(board, word, i, j, 0);
            }
        }

        return flag;
    }

    private void backtrack(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) {
            flag = true;
            return;
        }
        if (
            i < 0 ||
            i > board.length - 1 ||
            j < 0 ||
            j > board[i].length - 1 ||
            board[i][j] != word.charAt(idx)
        ) return;

        char temp = board[i][j];
        board[i][j] = '.';
        for (int[] d : direction) {
            backtrack(board, word, i + d[0], j + d[1], idx + 1);
        }
        board[i][j] = temp;
    }
}
