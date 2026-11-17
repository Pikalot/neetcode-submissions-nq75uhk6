class WordDictionary {
    private boolean endOfWord;
    private Map<Character, WordDictionary> children;

    public WordDictionary() {
        this.endOfWord = false;
        this.children = new HashMap<>();
    }

    public void addWord(String word) {
        WordDictionary curr = this;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new WordDictionary());
            }
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(this, word, 0);
    }

    private boolean dfs(WordDictionary root, String word, int i) {
        WordDictionary curr = root;

        for (int j = i; j < word.length(); j++) {
            char c = word.charAt(j);
            if (c == '.') {
                for (WordDictionary child : curr.children.values()) {
                    if (child != null && dfs(child, word, j + 1)) return true;
                }
                return false;
            }
            else {
                if (!curr.children.containsKey(c)) return false;
                curr = curr.children.get(c);
            }
        }
        return curr.endOfWord;
    }
}
