import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Map<String, Integer>> GIFT_COUNTER = new HashMap<>();
        Map<String, Integer> GIFT_POWER = new HashMap<>();
        for(int i = 0; i<friends.length; i++){
            for(int j = 0; j<friends.length; j++){
                if(i == j) continue;
                Map<String, Integer> counter = GIFT_COUNTER.getOrDefault(friends[i], new HashMap<String, Integer>());
                counter.put(friends[j], 0);
                GIFT_COUNTER.put(friends[i], counter);
            }
        }
        
        for(int i = 0; i<gifts.length; i++){
            String[] gift = gifts[i].split(" ");
            Map<String, Integer> counter = GIFT_COUNTER.get(gift[0]);
            counter.put(gift[1], counter.get(gift[1])+1);
        }
        
        GIFT_POWER = calculateGiftPower(GIFT_COUNTER);
        answer = calculateMaxGift(GIFT_COUNTER, GIFT_POWER);
        return answer;
    }
    
    public int calculateMaxGift(Map<String, Map<String, Integer>> GC, Map<String, Integer> GP){
        int max = 0;
        for(String giver : GC.keySet()){
            Map<String, Integer> takers = GC.get(giver);
            int giverCnt = 0;
            for(String taker : takers.keySet()){
                int in = GC.get(taker).get(giver); // Taker가 Giver에게 준 개수
                int out = takers.get(taker); // Giver 가 Taker에게 준 개수
                if(in == out){
                    if(GP.get(giver) > GP.get(taker)) giverCnt++;
                } else if( out > in ) giverCnt++;
            }
            max = Math.max(max, giverCnt);
        }
        
        return max;
    }
    
    public Map<String, Integer> calculateGiftPower(Map<String, Map<String, Integer>> GC){
        Map<String, Integer> power = new HashMap<>();        
        
        for(String giver : GC.keySet()){
            int in = 0;
            int out = 0;
            Map<String, Integer> takers = GC.get(giver);
            for(String taker : takers.keySet()){
                out += takers.get(taker);
                in += GC.get(taker).get(giver);
            }
            power.put(giver, out - in);
        }
        return power;
    }
}