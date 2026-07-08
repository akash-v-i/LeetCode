class Trie {
    Trie[] arr;
    boolean flag;

    Trie() {
        arr = new Trie[26];
        flag = false;
    }
}

class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();

        for (String word : dictionary) {
            insert(word, 0, root);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {

            int len = find(words[i], 0, root);

            if (len == -1) {
                sb.append(words[i]);
            } else {
                sb.append(words[i].substring(0, len));
            }

            if (i != words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public int find(String str, int index, Trie root) {

        if (root.flag) {
            return index;
        }

        if (index == str.length()) {
            return -1;
        }

        int idx = str.charAt(index) - 'a';

        if (root.arr[idx] == null) {
            return -1;
        }

        return find(str, index + 1, root.arr[idx]);
    }

    public void insert(String str, int index, Trie root) {

        if (index == str.length()) {
            root.flag = true;
            return;
        }

        int idx = str.charAt(index) - 'a';

        if (root.arr[idx] == null) {
            root.arr[idx] = new Trie();
        }

        insert(str, index + 1, root.arr[idx]);
    }
}