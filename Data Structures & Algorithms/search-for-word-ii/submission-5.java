class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        TrieNode root = new TrieNode();

        for (String w : words) {
            root.insert(w);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(res, root, board, i, j, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(Set<String> set, TrieNode root, char[][] board, int i, int j, String word) {
        if (
            i < 0 ||
            j < 0 ||
            i == board.length ||
            j == board[i].length ||
            board[i][j] == '.' ||
            root.children[board[i][j] - 'a'] == null
        ) return;

        root = root.children[board[i][j] - 'a'];
        word += board[i][j];
        if (root.eow) set.add(word);
        
        char temp = board[i][j];
        board[i][j] = '.';
        dfs(set, root, board, i + 1, j, word);
        dfs(set, root, board, i - 1, j, word);
        dfs(set, root, board, i, j + 1, word);
        dfs(set, root, board, i, j - 1, word);
        board[i][j] = temp;
    }
}

class TrieNode {
    private boolean eow;
    private TrieNode[] children;

    public TrieNode() {
        this.eow = false;
        this.children = new TrieNode[26];
    }

    public void insert(String word) {
        TrieNode curr = this;

        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (curr.children[i] == null) curr.children[i] = new TrieNode();
            curr = curr.children[i];
        }
        curr.eow = true;
    }
}
