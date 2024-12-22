import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> location = new HashMap<>();
        // 최초 위치
        for(int i = 0; i<players.length; i++){
            location.put(players[i], i);
        }
        
        for(int i = 0; i<callings.length; i++){
            swap(location, players, callings[i]);
        }
        
        return players;
    }
    
    public void swap(Map<String, Integer> score, String[] players, String call){
        int idx = score.get(call);
        String prev = players[idx-1];
    
        score.put(call, score.get(call)-1);
        score.put(prev, score.get(prev)+1);
        
        players[idx] = prev;
        players[idx-1] = call;

    }
}