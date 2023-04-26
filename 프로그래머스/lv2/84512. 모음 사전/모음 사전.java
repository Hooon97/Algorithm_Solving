import java.util.*;

class Solution {
    static ArrayList<String> a;
    static String[] words;
    public int solution(String word) {
        int answer = 0;
        a = new ArrayList<>();
        words = new String[]{"A","E","I","O","U"};
        perm("");
        
        for(int i = 0; i<a.size(); i++){
            if(word.equals(a.get(i))){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public void perm(String s){
        if(s.length() > 5) 
            return;
        a.add(s);
        for(int i = 0; i<5; i++){
            perm(s+words[i]);
        }
        
        
    }
}