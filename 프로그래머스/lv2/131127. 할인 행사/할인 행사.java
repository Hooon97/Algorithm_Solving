import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> prod = new HashMap<>();
        for(int i = 0; i<want.length; i++)
            prod.put(want[i], number[i]);
        
        for(int i = 0; i<10; i++){
            if(!prod.containsKey(discount[i])) continue;
            addDiscount(prod, discount[i]);
        }
        if(isDiscountable(prod)) answer++;
        for(int i = 1; i<=discount.length-10; i++){
            removeDiscount(prod, discount[i-1]);
            addDiscount(prod, discount[i+9]);
            if(isDiscountable(prod)) answer++;
        }
        
        return answer;
    }
    private void removeDiscount(HashMap<String, Integer> m, String prod){
        if(!m.containsKey(prod)) return;
        m.put(prod, m.get(prod)+1);
    }
    
    private void addDiscount(HashMap<String, Integer> m, String prod){
        if(!m.containsKey(prod)) return;
        m.put(prod, m.get(prod)-1);
    }
    
    private boolean isDiscountable(HashMap<String,Integer> m){
        for(int i : m.values()){
            if(i > 0) 
                return false;
        }
        return true;
    }
    private void printValues(HashMap<String, Integer> m){
        for(int i : m.values())
            System.out.print(i+" ");
        System.out.println();
    }
}