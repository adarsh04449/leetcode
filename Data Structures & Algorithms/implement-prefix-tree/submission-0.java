class PrefixTree {
    class TrieNode{
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    public TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = findWord(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return findWord(prefix) != null;
    }

    public TrieNode findWord(String word){
        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return null;
            }
            curr = curr.children.get(ch);
        }

        return curr;
    }
}
