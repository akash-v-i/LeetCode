class Trie {
    Trie arr[];
    boolean flag;

    public Trie() {
        arr = new Trie[26];
        flag = false;
    }

    public void insert(String word) {
        Trie curr = this;

        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';

            if (curr.arr[ch] == null) {
                curr.arr[ch] = new Trie();
            }

            curr = curr.arr[ch];
        }

        curr.flag = true;
    }

    public boolean search(String word) {

        Trie curr=this;

        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(curr.arr[idx]==null){
                return false;
            }
            curr=curr.arr[idx];
        }
        return curr.flag;
    }

    public boolean startsWith(String prefix) {

        Trie curr=this;
        for(char ch:prefix.toCharArray()){
            int idx=ch-'a';
            if(curr.arr[idx]==null) return false;
            curr=curr.arr[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */