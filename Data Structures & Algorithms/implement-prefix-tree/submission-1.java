class PrefixTree {
    private boolean eow;
    private PrefixTree[] children;

    public PrefixTree() {
        this.eow = false;
        this.children = new PrefixTree[26];     
    }

    public void insert(String word) {
        PrefixTree curr = this;

        for (char c : word.toCharArray()) {
            int i = c - 'a';
            
            if (curr.children[i] == null) curr.children[i] = new PrefixTree();
            curr = curr.children[i];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;

        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (curr.children[i] == null) return false;
            curr = curr.children[i];
        }
        return curr.eow;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;

        for (char c : prefix.toCharArray()) {
            int i = c - 'a';

            if (curr.children[i] == null) return false;
            curr = curr.children[i];
        }
        return true;
    }
}
