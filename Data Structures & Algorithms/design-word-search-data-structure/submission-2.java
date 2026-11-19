class WordDictionary {
    private boolean eow;
    private WordDictionary[] children;

    public WordDictionary() {
        this.eow = false;
        this.children = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary curr = this;

        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (curr.children[i] == null) curr.children[i] = new WordDictionary();
            curr = curr.children[i];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        return dfs(word, this, 0);
    }

    private boolean dfs(String word, WordDictionary root, int i) {
        WordDictionary curr = root;

        for (int j = i; j < word.length(); j++) {
            char c = word.charAt(j);

            if (c == '.') {
                for (WordDictionary child : curr.children) {
                    if (child != null && dfs(word, child, j + 1)) return true;
                }
                return false;
            }
            else {
                int idx = c - 'a';
                if (curr.children[idx] == null) return false;
                curr = curr.children[idx];
            }
        }
        return curr.eow;
    }
}
