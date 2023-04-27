import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> A = new HashMap<>();
        Map<Integer, Integer> B = new HashMap<>();
        for(int i : topping) {
            if(B.containsKey(i)){
                B.put(i, B.get(i)+1);
            }
            else B.put(i, 1);
        }
        
        for(int i = 0; i<topping.length; i++){
            putA(A, topping[i]);
            removeB(B, topping[i]);
            if(isFair(A,B)) answer++;
        }
        
        return answer;
    }
    public void putA(Map<Integer, Integer> A, int i){
        if(A.containsKey(i)){
            A.put(i, A.get(i)+1);
        }
        else A.put(i, 1);
    }
    public void removeB(Map<Integer, Integer> B, int i){
        if(B.get(i) == 1){
            B.remove(i);
        }
        else{
            B.put(i, B.get(i)-1);
        }
    }
    public boolean isFair(Map<Integer, Integer> A, Map<Integer, Integer> B){
        if(A.size() == B.size()) return true;
        else return false;
    }
}