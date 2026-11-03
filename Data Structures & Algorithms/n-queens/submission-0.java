class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(res, board, new HashSet<>(), new HashSet<>(), new HashSet<>(), 0);
        return res;
    }

    private void backtrack(List<List<String>> list, char[][] board, Set<Integer> cols, Set<Integer> posDia, Set<Integer> negDia, int i) {
        if (i == board.length) {
            List<String> path = new ArrayList<>();
            
            for (char[] row : board) {
                path.add(new String(row));
            }

            list.add(path);
            return;
        }

        
        for (int j = 0; j < board.length; j++) {
            if (cols.contains(j) || posDia.contains(i + j) || negDia.contains(i - j)) continue;

            cols.add(j);
            posDia.add(i + j);
            negDia.add(i - j);
            board[i][j] = 'Q';
            
            backtrack(list, board, cols, posDia, negDia, i + 1);
            
            cols.remove(j);
            posDia.remove(i + j);
            negDia.remove(i - j);
            board[i][j] = '.';
        }
    }
}
