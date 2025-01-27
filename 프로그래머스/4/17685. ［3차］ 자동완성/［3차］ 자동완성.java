import java.util.*;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
                
        Trie trie = createTrie(words);
        for(int i = 0; i<words.length; i++){
            int result = findDepth(trie, words[i]);
            answer += result;
        }
        
        return answer;
    }
    
    public int findDepth(Trie trie, String str){
        int depth = -1;
        int idx = 0;
        Trie root = trie;
        
        while(depth < str.length()-1){
            depth++;
            idx = str.charAt(depth) - 'a';
            if(root.isEnd[idx]) return depth+1;
            root = root.next[idx];
            // depth++;
        }
        
        return depth+1;
    }
    
    public Trie createTrie(String[] words){
        Trie root = new Trie();
        
        for(String word : words){
            Trie trie = root;
            int idx = 0;
            for(char wChar : word.toCharArray()){
                idx = wChar - 'a';
                if(trie.next[idx] == null){
                    trie.next[idx] = new Trie();
                    trie.isEnd[idx] = true;
                } else {
                    trie.isEnd[idx] = false;
                }
                trie = trie.next[idx];
            }
            trie.word = word;
        }
        
        return root;
    }
    
    class Trie{
        Trie[] next = new Trie[26];
        String word = "";
        boolean[] isEnd = new boolean[26];
        
    }
}