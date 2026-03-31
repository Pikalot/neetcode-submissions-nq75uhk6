class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> square = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            if (rows.get(r) == null) rows.put(r, new HashSet<Character>());
            for (int c = 0; c < board[r].length; c++) {
                if (cols.get(c) == null) cols.put(c, new HashSet<Character>());
                String key = r/3 + ", " + c/3;
                if (square.get(key) == null) square.put(key, new HashSet<Character>());
                
                if (board[r][c] == '.') continue;
                
                if (rows.get(r).contains(board[r][c]) ||
                    cols.get(c).contains(board[r][c]) ||
                    square.get(key).contains(board[r][c])) 
                    return false;
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                square.get(key).add(board[r][c]);
            }            
        }

        return true;
    }
}
