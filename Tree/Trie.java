package Tree;

import java.util.Arrays;
import java.util.List;

public class Trie {
    Trie[] child;
    boolean wordEnd;

    public Trie() {
        wordEnd = false;
        child = new Trie[26];
    }

    public static void insertKey(Trie root, String word) {
        Trie current = root;
        for (char c : word.toCharArray()) {
            if (current.child[c - 'a'] == null) {
                Trie newNodeTrie = new Trie();
                current.child[c - 'a'] = newNodeTrie;

            }
            current = current.child[c - 'a'];
        }
        current.wordEnd = true;
    }

    static boolean searchKey(Trie root, String key) {
        Trie curr = root;
        for (char c : key.toCharArray()) {
            if (curr.child[c - 'a'] == null)
                return false;
            curr = curr.child[c - 'a'];
        }
        return curr.wordEnd;
    }

    public static void main(String args[]) {
        Trie root = new Trie();
        List<String> arr = Arrays.asList(
                "and", "ant", "do", "geek", "dad", "ball");
        for (String s : arr) {
            insertKey(root, s);
        }

        // One by one search strings
        List<String> searchKeys = Arrays.asList("do", "gee", "bat");
        for (String s : searchKeys) {
            System.out.println("Key : " + s);
            if (searchKey(root, s))
                System.out.println("Present");
            else
                System.out.println("Not Present");
        }
    }
}
