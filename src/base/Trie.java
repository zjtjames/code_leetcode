/**
 * created by Zheng Jiateng on 2019/5/22.
 */
package base;

/**
 * 208. Implement Trie (Prefix Tree) 单词查找树
 */
public class Trie {
    private TrieNode root;

    private class TrieNode{
        private boolean isEnd;

        private final int R = 26; // 26个小写字母

        private TrieNode[] links;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }


        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    // o(m) m为单词的长度
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            // 如果此字母链接向null 则先创建此字母链接向的结点
            if (node.get(currentChar) == null) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    // o(m) m为单词的长度
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    // 搜索一个前缀或一个完整的key，返回搜索停止时的结点
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.get(currentChar) == null) {
                return null;
            }
            node = node.get(currentChar);
        }
        return node;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

