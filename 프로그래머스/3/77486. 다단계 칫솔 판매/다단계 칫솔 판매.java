import java.util.*;

class Solution {
    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> profit = new HashMap<>();
    
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i<enroll.length; i++)
            parent.put(enroll[i], referral[i]);
        
        for(int i = 0; i<seller.length; i++){
            share(seller[i], amount[i]*100);
        }
        
        for(int i = 0; i<answer.length; i++){
            answer[i] = profit.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    public void share(String seller, int price){
        int charge = price/10;
        
        profit.put(seller, profit.getOrDefault(seller, 0)+(price-charge));
        if(charge > 0 && parent.containsKey(seller)){
            share(parent.get(seller), charge);
        }
    }
}