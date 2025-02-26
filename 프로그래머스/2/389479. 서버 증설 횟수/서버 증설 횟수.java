import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];
        Arrays.fill(server, 1); // 기본 서버 개수
        for(int i = 0; i<24; i++){
            if(server[i] * m <= players[i]){
                System.out.println("s-capa : "+server[i] * m+" player : "+players[i]);
                answer += increaseServer(server, players[i], i, m, k);
            }
        }
        
        return answer;
    }
    public int increaseServer(int[] server, int player, int start, int capa, int dura){
        
        int requiredServer = (player + capa ) / capa;
        int curServer = server[start];
        int cnt = requiredServer - curServer;
        for(int i = 0; i<dura && i+start<24; i++){
            server[i+start] += cnt;
        }
        
        return cnt;
    }
}