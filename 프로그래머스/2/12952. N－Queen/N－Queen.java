import java.util.*;

class Solution {
    public int solution(int n) {
        int[] order = new int[n];
        return NQueen(order, n, 0);
    }
    
    public int NQueen(int[] order, int n, int idx){
        if(idx == n) return 1;
        int result = 0;
        for(int i = 0; i<n; i++){
            order[idx] = i;
            if(valid(order, idx)){
                result += NQueen(order, n, idx+1);
            }
        }
        return result;
    }
    
    public boolean valid(int[] order, int idx){
        for(int i = 0; i<idx; i++){
            if(order[idx] == order[i]) return false;
            if(Math.abs(order[i] - order[idx]) == Math.abs(i-idx)) return false;
        }
        return true;
    }
}