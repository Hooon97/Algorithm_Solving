import java.util.*;

class Solution {
    public int solution(String s) {
        String answer = s;
        int leng = 1;
        while(leng <= s.length()/2){
            String tmp = compressSentence(s, leng++);
            if(tmp.length() < answer.length())
                answer = tmp;
        }
        
        return answer.length();
    }
    String compressSentence(String s, int n){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> sep = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            if(i+n > s.length()){
                sep.add(s.substring(i,s.length()));
                break;
            }
            
            sep.add(s.substring(i, i+n));
            i += n;
        }

        int count = 1;
        String cur = sep.get(0);
        
        for(i = 1; i<sep.size(); i++){
            if(cur.equals(sep.get(i))){
                count++;
                continue;
            }
            else{
                if(count > 1) sb.append(count+cur);
                else sb.append(cur);
                
                count = 1;
                cur = sep.get(i);
            }

        }
        
        if(count > 1) sb.append(count+cur);
        else sb.append(cur);

        return sb.toString();
    }
}