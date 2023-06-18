package tries;

public class Trie {

    private static class TrieNode{
        char data;
        boolean isTerminating;
        TrieNode[] children;
        public TrieNode(char data){
            this.data = data;
            isTerminating = false;
            children = new TrieNode[26];
        }
    }

    private TrieNode root;
    public Trie(){
        root = new TrieNode('\0');
    }

    public void add(String word){

    }
    public static void main(String[] args) {

    }

}
