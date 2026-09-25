class WordDictionary {
    class TreeNode {
        TreeNode[] children;
        boolean isWordEnd;
        public TreeNode() {
            this.children = new TreeNode[26];
            this.isWordEnd = isWordEnd;
        }
    }

    private TreeNode root;
    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TreeNode();
            }
            curr = curr.children[index];
        }
        curr.isWordEnd = true;
    }

    public boolean search(String word) {
        TreeNode node = root;
        return find(word, node, 0);
    }
    public boolean find(String word, TreeNode node, int index) {
        if (node == null)
            return false;
        if (index == word.length()) {
            return node.isWordEnd;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (int k = 0; k < 26; k++) {
                if (node.children[k] != null && find(word, node.children[k], index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = ch - 'a';
            return find(word, node.children[idx], index + 1);
        }
    }
}
