/**
        d
    g       o

*/ 

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        int idx = 0;
        while (idx < word.length()) {
            char c = word.charAt(idx++);
            if (!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
        }
        
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int idx = 0;
        while (idx < prefix.length()) {
            char c = prefix.charAt(idx++);
            if (!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
        }
            
        return true;    
    }
}

class TrieNode {
    boolean endOfWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
        this.endOfWord = false;
        this.children = new HashMap<>();
    }
}
