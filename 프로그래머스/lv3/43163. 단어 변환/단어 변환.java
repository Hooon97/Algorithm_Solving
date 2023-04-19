import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean flag = false;
        boolean[] visit = new boolean[words.length];
        for(String s : words){
            if(target.equals(s)) flag = true;
        }
        if(!flag) return 0;
        
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(0, begin));
        while(!q.isEmpty()){
            Word cur = q.poll();
            
            if(cur.word.equals(target)){
                answer = cur.depth;
                break;
            }
            
            for(int i = 0; i<words.length; i++){
                if(visit[i]) continue;
                if(!isChangable(cur.word, words[i])) continue;
                q.add(new Word(cur.depth+1, words[i]));
                visit[i] = true;
            }
        }
        
        return answer;
    }
    private boolean isChangable(String curWord, String nextWord){
        int count = 0;
        for(int i = 0; i<curWord.length(); i++){
            if(curWord.charAt(i) != nextWord.charAt(i)){
                count++;
            }
            if(count > 1) return false;
        }
        return true;
    }
}

class Word{
    int depth;
    String word;
    Word(int depth, String word){
        this.depth = depth;
        this.word = word;
    }
}