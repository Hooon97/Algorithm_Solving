import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> peop = new ArrayList<>();
        long facto = 1;
        int idx = 0;
        for(int i = 1; i<n+1; i++){
            facto *= i;
            peop.add(i);
        }
        k -= 1;
        
        while(n > 0){
            facto /= n;
            int val = (int)(k / facto);
            answer[idx++] = peop.get(val);
            peop.remove(val);
            k %= facto;
            n--;
        }
        
        return answer;
    }
}